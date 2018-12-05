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

> 用在@Compment @