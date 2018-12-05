[TOC]
# - Spring核心注解



## 概览

> - `@Autowired`
> - `@Bean`
> - `@Qualifier`
> - `@Value`
> - `@DependsOn`
> - `@Lazy`
> - `@Lookup`
> - `@Primary`
> - `@Scope`
> - `@Profile`
> - `@Import`
> - `@ImportResource`
> - `@PropertySource`
> - `@PropertySources`

## 详解

### `@Autowired`

> `@Autowired`可以用来标记`setter`方法、`构造函数`、或`字段属性`

### `@Bean`

> `@Bean`是方法级别的注解，是XML Bean的直接模拟

### `@Qualifier`

> 注入限定，用于在多个实现类或者子类注入时限定注入的具体类。

### `@Required`

> 用于标记在Bean初始化时必须注入的属性，用于setter方法，在spring 5.1中已经被构造方法注入取代，或者直接实现InitializingBean接口

### `@Value`

> 1. 为属性设置默认值 `@Value(true)`
> 2. 取读Spring环境变量 `@Value("${ELEMENT_NAME}")`
> 3. 取读系统环境变量 `@Value("${java.home}")`

### `@DependsOn`

> 用在`@Compment @Bean`注解上用以表示bean所依赖的其他bean

### `@Lazy`

> `@Lazy`可以用来标记`@Component @Bean @Configuration` 被`@Lazy`标记的Bean将不会在Spring初始化时被实例化，而是等到其他bean调用或者依赖时才会初始化。

### `@Primary`

> `@Primary`注解用以标记最高优先级的bean也可以理解为默认的bean，如在多个接口实现类或者多个子类中，标记了`@Primary`的bean会被默认引用，而引用其他子类则需要使用`@Qualifier`来标注候选bean名称

### `@Scope`

> `@Scope`用来标记类表明bean的作用域，常见作用域有`singleton,prototype,request,session,globalSession`

### `@Profile`

> 用于标记`@Component、@Bean`表示当特定的配置文件被激活时才注册该bean

### `@Import`

> 在基于Java注解配置的项目中应用其他`@Configuration`中定义的bean

### `@ImportResource`

> 用于将xml配置文件中的bean加载到ApplicationContext中,使项目中既可以使用xml配置文件又可以直接使用Java注解配置。

### `@PropertySource`

> 用以从配置文件中读取配置

### `@PropertySources`

> 多个`@PropertySource`

