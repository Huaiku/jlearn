[TOC]
# Spring

## 1.0 Spring Core Technologies `Spring 技术核心`

> Spring最核心的模块是`Spring Framework’s Inversion of Control (IoC) container`，我们通常称之为`IoC`亦称控制反转模块

### 1.1 The IoC Container `控制反转容器`

#### 1.1.1 Introduction to the Spring Ioc Container and Beans `关于SpringIoc容器和Beans的介绍`
>`IoC`控制反转也称之为`DI (Dependency Injection)`依赖注入，依赖注入是一个过程，其中对象仅通过`构造函数参数`、`工厂方法的参数`或从`工厂方法构造`或返回对象实例之后在对象实例上设置的属性(`setter方法`)来定义它们的依赖性，这一过程就称之为依赖注入。所以通常意义上来讲，依赖注入的方式主要有`构造器注入、setter注入、接口注入`
>
>`org.springframework.beans` and `org.springframework.context`是IoC容器的基础包`BeanFactory`接口提供了一套对象和类的高级管理机制，简言之`BeanFactory`提供了配置框架和基础功能。`ApplicationContext`是`BeanFactory`的子接口，在`BeanFactroy`的基础上添加了另外一些高级功能。
>
>在Spring中来自你自身应用骨架并且交由SpringIoC管理的的对象我们称之为`beans`，一个bean是一个由SpringIoC容器实例化，装配和管理的对象。

#### 1.1.2 Container Overview `容器概览`

> The `org.springframework.context.ApplicationContext`接口代表SpringIoC容器，其主要负责对象实例化，配置，组装bean，容器通过配置文件中定义的对象实例化方式、配置信息、装配获取信息和指令。配置文件通常有`XML，Java注解，或者Java Code`主要负责描述应用中对象的依赖关系。
>
> Spring提供了多个`ApplicationContext`接口，在单应用程序中，通常通过创建`ClassPathXmlApplicationContext`或者`FileSystemXmlApplicationContext`实例。我们可以通过一小段xml配置信息来通知容器支持多种配置方式。
>
> https://docs.spring.io/spring/docs/5.1.2.RELEASE/spring-framework-reference/images/container-magic.png)

## 关于ApplicationContext

> - ApplicationContextAware 接口，可以用来探知bean，获取IoC容器对象（ApplicationContext）

