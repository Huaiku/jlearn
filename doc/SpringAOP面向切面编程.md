[TOC]
# SpringAOP面向切面编程

## 1. 面向切面编程 Aspect Oriented Programming 

> 面向切面编程（AOP）是面向对象编程（OOP）的一种补充和完善，它提供了另一种解决和思考程序结构的方式。在OOP中模块的核心元是类，而在AOP中模块的核心元为切面，切面可以使诸如事务管理等的关注点模块化。使用同一个切面可以同时截断多个类型和类，可以在多个类型和类的截断点进行相同的逻辑和业务控制，比如上面提到的事务管理。
>
> AOP 是Spring的重要组件之一，但是`Spring IoC`容器并不依赖AOP，所以当不需要使用AOP时可以不使用。AOP通过提供一个强有力的中间件解决方案来完善`Spring IoC`容器
> ![cutacross](C:\Users\junit\Desktop\cutacross.jpg)
>
> - 代码示例
>
>   ```java
>   @Component
>   public class UserHandler {
>   	public String getUserName() {
>   		return "Huaiku..";
>   	}
>   }
>   
>   /**
>    * 	切面，扩展原来类的功能，提供日志记录功能
>    * @author Huaiku
>    * @date Dec 12, 2018
>    */
>   @Aspect
>   @Component
>   public class LoggerAspect {
>   	private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
>   
>       // 一个通知方法，环绕通知
>   	@Around("execution(** org.springaop.user.UserHandler.getUserName(..))")
>   	public String processLogger(ProceedingJoinPoint joinPoint) {
>   		
>   		logger.info("即将开始调用UserHandler getUserName()方法...此日志时通过切面的方式记录");
>   		Object returnValue = null;
>   		try {
>   			returnValue = joinPoint.proceed();
>   			logger.info("调用方法完毕，方法返回结果为：{}", returnValue.toString());
>   		} catch (Throwable e) {
>   			logger.error("方法调时产生了一个错误，错误信息如下：{}", e.getMessage());
>   		}
>   
>   		return returnValue.toString();
>   	}
>   }
>   
>   @SpringBootApplication
>   @EnableAspectJAutoProxy
>   public class SpringAOP {
>   
>   	private static final Logger logger = LoggerFactory.getLogger(SpringAOP.class);
>   
>   	public static void main(String[] args) {
>   		SpringApplication.run(SpringAOP.class, args);
>   	}
>   
>   	@Bean public CommandLineRunner test(final UserHandler handler) {
>   		return args -> {
>   			String userName = handler.getUserName();
>   			logger.info("user name: {}",userName);
>   		};
>   	}
>   }
>   ```
>
> - 日志打印
>   ```verilog
>   INFO :-- [main .. ]即将开始调用UserHandler getUserName()方法...此日志时通过切面的方式记录 
>   INFO :-- [main .. ]调用方法完毕，方法返回结果为：Huaiku.. 
>   INFO :-- [main .. ]user name: Huaiku.. 
>   ```
>
> - 分析
>
>   从代码中可以看出来`UserHandler`类的`getUserName()`方法本身没有记录任何日志，但是我们通过AOP扩展了该方法，为该方法创建了一个环绕通知，使得我们可以在该方法调用前后，以及抛出异常时能够记录相应的日志以供分析，达到了扩展类中方法的目的，而不用改动原代码逻辑，使得和业务无关的日志记录和日志剥离开，也达到了模块化日志记录的功能。
>

## 2. AOP核心概念

> - 切面（Aspect）: 切面是一个模块化的关注点，它可以截断很多类的调用。在java应用中事务管理是一个很好的横切关注点（crosscutting concern）。我们可以通过xml或者annotation注解的方式来实现一个切面例如上面`LoggerAspect`类利用`@Aspect`来声明其是一个切面。
> - 连接点（Join Point）: 链接点是程序执行过程中的一个点，比如一个方法的执行或者异常的处理，在SpringAOP中链接点通常代表着一个方法的执行。
> - 通知（Adivce）: 切面在某一个连接点上进行的操作称之为通知，比如上例中的`processLogger()`方法是切面中定义的一个环绕通知，通知包含前置通知，后置通知，环绕通知，异常通知，返回通知等。
> - 切入点（Pointcut）: 是可以匹配连接点的一组断言语句。通知关联一个切入点表达式，在任何符合断言的地方执行通知方法，将通知插入到程序的运行中去`execution(** org.springaop.user.UserHandler.getUserName(..))`便是一个切入点。
> - 引入（Introduction）: 可以声明额外的方法或者属性，SpringAOP可以为任何被通知的类引入新的接口以及对应的实现
> - 目标类（Target Object）: 被一个或多个切面通知的类。
> - AOP 代理（AOP Proxy）:  一个被SpringAOP框架创建的代理类。Spring框架中，通常会根据实际情况选择使用JDK动态代理或者CGLIB动态代理。
> - 织入（Weaving）: 链接切面和目标对象创建通知类，SpringAop在运行时织入。

## 3. SpringAOP支持的通知类型



> SpringAOP支持的通知类型有5中分别为：前置通知（Before advice），返回通知（After returning advice），异常通知（After throwing advice），结束通知（After (finally) advice），环绕通知（Around advice）
>
> - 前置通知（Before advice）：在连接点之前执行，前置通知无法阻断程序执行。
> - 返回通知（After returning advice）：连接点之后执行，比如一个方法在没有异常的情况下返回后，会执行该通知。
> - 异常通知（After throwing advice）：在方法异常退出时执行该通知。
> - 结束通知（After (finally) advice）：正常或异常返回都会执行的通知。
> - 环绕通知（Around advice）：是一个环绕链接的点的通知，如上例所示便是一个环绕通知。

## 4. AOP 代理

> SpringAOP默认使用的是JDK代理，只有在目标类没有实现任何接口的情况下使用CGLIB代理，因为JDB代理是基于接口的代理方法，而CGLIB无此限制。

## 5. 声明切入点

> 切入点决定哪些链接点在目标类的方法在被调用时触发通知。SpringAOP仅支持基于方法执行的连接点。
>
> 下面代码以注解的形式定义了一个切入点
>
> ```java
> @Pointcut("execution(* transfer(..))") // 切入表达式
> private void anyOldTransfer(); // 切入点签名
> ```
>
> 和最上面例子提供的代码相比，此处定义切入点是通过@Pointcut注解实现的。
>
> **SpringAOP中支持的切入点指示器**
>
> 1. `execution` 匹配方法执行链接点
> 2. `within` 限制匹配连接点在某一个type内。
> 3. `this` 限制匹配链接点在某一个具体的类型内。
> 4. `target` 限制匹配连接点在某一个目标类。
> 5. `args` 利用参数限制匹配连接点
> 6. `@target` 利用方法注解限制匹配连接点
> 7. `@args` 利用参数注解限制连接点
> 8. `@within` 利用类注解限制链接点
> 9. `@annotation` 利用主题注解限制连接点

## 6. 组合切入表达式

```java
@Pointcut("execution(public * *(..))")
private void anyPublicOperation(){};
```
>
> 该切入点定义一个切入任意类、任意类型的任意方法、任意参数的public方法。
>
> ![pointcutB](C:\Users\junit\Desktop\pointcutB.jpg)
>
>
