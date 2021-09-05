# 社交网站讨论区项目

<!--ts-->
* [社交网站讨论区项目](#社交网站讨论区项目)
   * [一、开发社区首页](#一开发社区首页)
      * [1.1 项目简介](#11-项目简介)
      * [1.2 搭建开发环境](#12-搭建开发环境)
      * [1.3 Spring 入门](#13-spring-入门)
      * [1.4 Spring MVC 入门](#14-spring-mvc-入门)
         * [<strong>Spring MVC</strong>](#spring-mvc)
         * [<strong>Thymeleaf</strong>](#thymeleaf)
      * [1.5 Mybatis入门](#15-mybatis入门)
         * [Mybatis](#mybatis)
      * [1.6 开发社区首页](#16-开发社区首页)
      * [1.7 项目调试技巧](#17-项目调试技巧)
      * [1.8 版本控制](#18-版本控制)
   * [二、开发社区登录模块](#二开发社区登录模块)
      * [2.1 发送邮件](#21-发送邮件)
      * [2.2-3 开发注册功能](#22-3-开发注册功能)
      * [2.4 会话管理](#24-会话管理)
      * [2.5 生成验证码](#25-生成验证码)
      * [2.6 开发登录、退出功能](#26-开发登录退出功能)
      * [2.7 显示登录信息](#27-显示登录信息)
      * [2.8 账号设置](#28-账号设置)
      * [2.9 检查登录状态](#29-检查登录状态)
   * [三、开发社区核心功能](#三开发社区核心功能)
      * [3.1 过滤敏感词](#31-过滤敏感词)
      * [3.2 发布帖子](#32-发布帖子)
      * [3.3 帖子详情](#33-帖子详情)
      * [3.4 事务管理](#34-事务管理)
      * [3.5 显示评论](#35-显示评论)
      * [3.6 添加评论](#36-添加评论)
      * [3.7 私信列表](#37-私信列表)
      * [3.8 发送私信](#38-发送私信)
      * [3.9 统一处理异常](#39-统一处理异常)
      * [3.10 统一记录日志](#310-统一记录日志)
         * [AOP的概念](#aop的概念)
         * [AOP的实现](#aop的实现)
   * [四、Redis，一站式高性能存储方案](#四redis一站式高性能存储方案)
      * [4.1 Redis入门](#41-redis入门)
      * [4.2 Spring整合Redis](#42-spring整合redis)
      * [4.3 点赞](#43-点赞)
      * [4.4 我收到的赞](#44-我收到的赞)
      * [4.5 关注、取消关注](#45-关注取消关注)
      * [4.6 关注列表、粉丝列表](#46-关注列表粉丝列表)
      * [4.7 优化登陆模块](#47-优化登陆模块)
   * [五、Kafka，构建TB级异步消息系统](#五kafka构建tb级异步消息系统)
      * [5.1 阻塞队列](#51-阻塞队列)
      * [5.2 Kafka入门](#52-kafka入门)
      * [5.3 Spring整合Kafka](#53-spring整合kafka)
      * [5.4 发送系统通知](#54-发送系统通知)
      * [5.5 显示系统通知](#55-显示系统通知)
   * [六、Elasticsearch，分布式搜索引擎](#六elasticsearch分布式搜索引擎)
      * [6.1 Elasticsearch入门](#61-elasticsearch入门)
      * [6.2 Spring整合Elasticsearch](#62-spring整合elasticsearch)
      * [6.3 开发社区搜索功能](#63-开发社区搜索功能)
   * [七、构建安全高效的企业服务](#七构建安全高效的企业服务)
      * [7.1 Spring Security](#71-spring-security)
      * [7.2 权限控制](#72-权限控制)
      * [7.3 置顶、加精、删除](#73-置顶加精删除)
      * [7.4 Redis高级数据类型](#74-redis高级数据类型)
      * [7.5  网站数据统计](#75--网站数据统计)
      * [7.6 任务执行和调度](#76-任务执行和调度)
      * [7.7 热帖排行](#77-热帖排行)
      * [7.8 生成长图](#78-生成长图)
      * [7.9 将文件上传至云服务器](#79-将文件上传至云服务器)
      * [7.10  优化网站的性能](#710--优化网站的性能)
   * [八、项目部署与总结](#八项目部署与总结)
      * [8.1 单元测试](#81-单元测试)
      * [8.2 项目监控](#82-项目监控)
      * [8.3 项目部署](#83-项目部署)
      * [8.4 项目总结](#84-项目总结)
      * [8.5 重要知识](#85-重要知识)
         * [<strong>MySQL 锁</strong>](#mysql-锁)
         * [<strong>MySQL 索引</strong>](#mysql-索引)
         * [<strong>Redis</strong>](#redis)
         * [<strong>Spring IoC</strong>](#spring-ioc)
         * [<strong>Spring MVC</strong>](#spring-mvc-1)

<!-- Added by: light, at: Sun Sep  5 19:35:07 CST 2021 -->

<!--te-->

## 一、开发社区首页

### 1.1 项目简介

1. 技术架构
Spring Boot
Spring、 Spring MVC、 Mybatis （三个合称SSM）
Redis、 Kafka、 Elasticsearch
Spring Security, Spring Actuator

### 1.2 搭建开发环境

**Apache Maven**

* 可以帮助我们构建项目、管理项目中的jar包

* [Maven Repository: Search/Browse/Explore (mvnrepository.com)](https://mvnrepository.com/)

**IntelliJ IDEA**
・目前最流行的Java集成开发工具

**Spring Initializer**
・创建 Spring Boot 项目的引导工具
https://start.spring.io/

目前 Spring Initializer 上没有 aop 了，可以创建完后在 pom 里加入下面的再重启idea

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

Spring Boot核心作用：
 - 起步依赖、自动配置、端点监控

### 1.3 Spring 入门

Spring全家桶
・Spring Framework
・Spring Boot
・Spring Cloud 做微服务
・Spring Cloud Data Flow 做数据集成，有更多平台客户端

**Spring Framework**
* Spring Core 
  * Ioc、AOP  管理对象的思想，前者面向对象，后者面向切面
    * Ioc(Inversion of Control) 面向对象编程的设计思想
      * Dependency Injection 依赖注入，是IoC思想的实现方式；IoC Container 是实现依赖注入的关键，本质上是一个工厂
* Spring Data Access
  * Transactions(管理事务), Spring MyBatis
* Web Servlet
  * Spring MVC
* Integration 集成
  * Email、Scheduling(定时任务)、AMQP(消息队列)、Security(安全控制)


如果一个接口有多个实现。调用接口时，加上 `@Primary` 标签的实现会被优先调用

服务器运行时，运行 `controller` 来控制展示什么内容，`controller` 去调用 `service`，`service` 去调用 `dao`（data access object）


### 1.4 Spring MVC 入门

HTTP
・Hypertext Transfer Protocol
・用于传输HTML等内容的应用层协议
・规定了浏览器和服务器之间如何通信，以及通信时的数据格式。
[developer.mozilla.org/zh-CN/]()  开发火狐的团队写的 HTTP、HTML、JS 等相关文档

#### **Spring MVC**

* Web Sever三层架构
  * 表现层、业务层、数据访问层
* MVC
  * Model：模型层
  * View：视图层
  * Controller：控制层
  * Controller 去调用业务层，业务层调用数据层，返回来封装成 Model，传给 View，转成 HTML，发给客户端
* 核心组件
  * 前端控制器：Dispatcherservlet  负责调度 Controller、View

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210804155404.png" style="zoom: 50%;"/>

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/20210804160757.png" style="zoom: 30%;"/>

<img src="https://docs.spring.io/spring-framework/docs/current/reference/html/images/mvc-context-hierarchy.png" style="zoom: 80%;"/>

<br/>

#### **Thymeleaf**
* 模板引擎。输入模板文件和 Model，输出 HTML 网页
  * 生成动态的HTML.
  * 倡导自然模板，即以HTML文件为模板。
* 常用语法
  * 标准表达式、判断与循环、模板的布局。

Thymeleaf 的缓存在开发的时候最好关掉（使得修改后立即可见），上线运行的时候开着（降低服务器压力）

Ctrl+N 打开IDEA的全局搜索

### 1.5 Mybatis入门

#### Mybatis

**核心组件**

* SqlSessionFactory：用于创建 SqlSession 的工厂类。
* SqlSession：MyBatis 的核心组件，用于向数据库执行SQL。
* 主配置文件：XML 配置文件，可以对 MyBatis 的底层行为做出详细的配置。
* Mapper 接口：就是 DAO 接口，在 MyBatis 中习惯性的称之为 Mapper。
* Mapper 映射器：用于编写 SQL，并将 SQL 和实体类映射的组件，采用 XML、注解均可实现。



IDEA Alt + Insert 快捷键弹出菜单，可以自动生成 getter、setter、toString 之类的函数

Java 项目中调用 MySQL 的一般方法：

* 在 entity 创建存放对应表里的数据的类xxx，
* 在 dao 创建对应的声明 sql 操作方法的接口文件 xxxMapper，
* 在 resources/mapper 创建包含对应方法的 sql 操作命令的 .xml 配置文件。或者直接在上面的接口里用 `@Insert, @Select` 等注解写
* 然后就可以直接使用接口中定义的方法对数据库进行操作。


```
application.properties 中
# MybatisProperties 部分的
mybatis.configuration.mapUnderscoreToCamelCase=true  # 把 head_url 和 headUrl 这两种写法自动匹配
```

### 1.6 开发社区首页

开发流程

* 1次请求的执行过程

分步实现

* 开发社区首页，显示前10个帖子
* 开发分页组件，分页显示所有的帖子



访问时是 Controller -> Service -> DAO -> DB，开发时则 DAO -> Service -> Controller 的顺序比较方便

```java
// @Param注解用于给参数取别名,
// 如果只有一个参数,并且在<if>里使用,则必须加别名.
int selectDiscussPostRows(@Param("userId") int userId);
```

在 HTML 中使用 Thymeleaf 时，像这样的 `th:src="${map.user.headerUrl}"` 会自动转换成 `map.get("user").getHeaderUrl()` 这样的

`th:utext` 和 `th:text`：`th:utext` 可以把转义字符显示成其该有的样子



### 1.7 项目调试技巧

**响应状态码的含义**

* [HTTP 响应代码 - HTTP | MDN (mozilla.org)](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status)
* 100 Continue，200 OK，302重定向，404 Not Found，500 Internal Server Error 等等

**服务端断点调试技巧**

**客户端断点调试技巧**

* 浏览器 F12，调试器，然后类似的打断点，在网页上做某个操作，然后跳到断点

**设置日志级别，并将日志输出到不同的终端**

* [Logback Manual (qos.ch)](http://logback.qos.ch/manual/index.html)

```java
package org.slf4j; 
public interface Logger {

  // Printing methods: 
  public void trace(String message);
  public void debug(String message);
  public void info(String message); 
  public void warn(String message); 
  public void error(String message); 
}
```



在 `application.properties` 中 添加

```
# logger
logging.level.com.nowcoder.community=debug
logging.file.name=d:/work/data/nowcoder/community.log
```

不过一般直接用 `logback-spring.xml`，可以进行更复杂的配置



### 1.8 版本控制

Git

![image-20210820203350566](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210820203350566.png)



## 二、开发社区登录模块

### 2.1 发送邮件

邮箱设置
* 启用客户端 SMTP 服务

Spring Email
* 导入 jar 包
* 邮箱参数配置
* 使用 JavaMailSender 发送邮件

模板引擎
* 使用 Thymeleaf 发送 HTML 邮件

### 2.2-3 开发注册功能

访问注册页面
* 点击顶部区域内的链接，打开注册页面。

提交注册数据
* 通过表单提交数据。
* 服务端验证账号是否已存在、邮箱是否已注册。
* 服务端发送激活邮件。

激活注册账号
* 点击邮件中的链接，访问服务端的激活服务。

### 2.4 会话管理

HTTP的基本性质
- HTTP是简单的
- HTTP是可扩展的
- HTTP是无状态的，有会话的。    多次请求之间是独立的、无关联的，不过可以通过 Cookies 创建有状态的会话

Cookie
- 是服务器发送到浏览器，并保存在浏览器端的一小块数据。
- 浏览器下次访该服务器时，会自动携带块该数据，将其发送给服务器。
- 因为要来回传，所以只能存字符串之类的小块数据

Session
- 是 JavaEE 的标准，用于在服务端内存记录客户端信息。
- 数据存放在服务端更加安全，但是也会增加服务端的内存压力。
- 可以把密码之类的隐私数据放在服务器，可以存放体积较大的各类数据。然后返回一个包含 sessionID 的 cookie，用来确认用户



有必要存东西的话尽量用 cookie

**单服务器部署可以用 session，大型网站分布式部署时比较少用 session（因为 session是在各个服务器上各自生成与存放的）**

* **粘性 session**，给浏览器 id，同一个浏览器总是给同一个服务器处理，但这样负载不够均衡。*不太好*
* **同步 session**，会对服务器性能有影响，并且会使各个服务器耦合。*不太好*
* **共享 session**，单独搞台服务器处理所有 session，其他服务器从它哪里获取信息。*不太好*，要是这台服务器挂了就麻烦了
* 尽量用 cookie，然后把敏感数据存到 Redis 数据库集群中。***比较好的方案***



### 2.5 生成验证码

Kaptcha
- 导入jar包
- 编写 Kaptcha 配置类
- 生成随机字符、生成图片

[kaptcha/wikis - Google Code Archive](https://code.google.com/archive/p/kaptcha/wikis)



### 2.6 开发登录、退出功能

访问登录页面
- 点击顶部区域内的链接，打开登录页面。

登录
- 验证账号、密码、验证码。
- 成功时，生成登录凭证，发放给客户端。
- 失败时，跳转回登录页。

退出
- 将登录凭证修改为失效状态。
- 跳转至网站首页。



### 2.7 显示登录信息

拦截器示例步骤
- 在 controller/interceptor 中定义拦截器，实现 Handlerlnterceptor
- 在 config 中配置拦截器，为它指定拦截、排除的路径（比如排除静态资源）

拦截器应用
- 在请求开始时查询登录用户
- 在本次请求中持有用户数据
- 在模板视图上显示用户数据
- 在请求结束时清理用户数据

![image-20210822150922717](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210822150922717.png)

```java
public class AlphaInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AlphaInterceptor.class);

    // 在Controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("preHandle: " + handler.toString());
        return true;    //false的话后面不会执行
    }

    // 在Controller之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle: " + handler.toString());
    }

    // 在TemplateEngine之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("afterCompletion: " + handler.toString());
    }
}
```



### 2.8 账号设置

上传文件
- 请求：必须是 POST 请求
- 表单：enctype= "multipart/form-data"
- Spring MVC：通过 MultipartFile 处理上传文件

开发步骤
- 访问账号设置页面
- 上传头像
- 获取头像



### 2.9 检查登录状态

使用拦截器
- 在方法前标注自定义注解
- 拦截所有请求，只处理带有该注解的方法

自定义注解
- 常用的元注解
@Target（声明作用位置）、@Retention（声明有效时间，是编译时有效还是运行时有效）、@Document（声明生成文档时要不要带上）、@Inherited（声明继承）
- 如何读取注解
Method.getDeclaredAnnotations()
Method.getAnnotation(Class<T> annotationClass)



没有做处理的话，比如之前在没登录时不显示账户设置页面，但实际还是可以直接输 url 访问设置页面



## 三、开发社区核心功能

### 3.1 过滤敏感词

前缀树
- 名称：Trie、字典树、查找树
- 特点：査找效率高，消耗内存大
- 应用：字符串检索、词频统计、字符串排序等

敏感词过滤器
- 定义前缀树
- 根据敏感词，初始化前缀树
- 编写过滤敏感词的方法，用前缀树对输入字符串做双指针遍历



### 3.2 发布帖子

AJAX
- Asynchronous JavaScript and XML
- 异步的 JavaScript 与 XML，不是一门新技术，只是一个新的术语。
- 使用 AJAX，网页能够将增量更新呈现在页面上，而不需要刷新整个页面。
- 虽然 X 代表 XML，但目前 JSON 的使用比 XML 更加普遍。
- https://developer.mozilla.org/zh-CN/docs/Web/Guide/AJAX

示例
- 使用 jQuery 发送 AJAX 请求。

实践
- 采用AJAX请求，实现发布帖子的功能。



服务端的 controller 接收 post 请求，返回 JSON 结果。因为返回的不是网页，所以要加上 `@ResponseBody` ；

网页的 js 发送 post，接收 JSON 并处理数据



### 3.3 帖子详情

DiscussPostMapper

DiscussPostService

DiscussPostController

index. html

- 在帖子标题上增加访问详情页面的链接

discuss-detail. html
- 处理静态资源的访问路径
- 复用 index.html 的 header 区域
- 显示标题、作者、发布时间、帖子正文等内容



```html
HTML的两个竖线（'|'）之间可以放常量加变量的形式
th:href="@{|/discuss/detail/${map.post.id}|}"
```



### 3.4 事务管理

什么是事务
- 事务是由 N 步数据库操作序列组成的逻辑执行单元，这系列操作要么全执行，要么全放弃执行。

事务的特性 (ACID)
- 原子性 (Atomicity): 事务是应用中不可再分的最小执行体。
- 一致性 (Consistency): 事务执行的结果，须使数据从一个一致性状态，变为另一个一致性状态。
- 隔离性 (Isolation): 各个事务的执行互不干扰，任何事务的内部操作对其他的事务都是隔离的。
- 持久性 (Durability): 事务一旦提交，对数据所做的任何改变都要记录到永久存储器中。



**事务的隔离性**

* 常见的并发异常
  * **第一类丢失更新**：某一个事务的回滚，导致另外一个事务已更新的数据丢失了
  * **第二类丢失更新**：某一个事务的提交，导致另外一个事务已更新的数据丢失了
  * **脏读**：某一个事务，读取了另外一个事务未提交的数据
  * **不可重复读**：某一个事务，对同一个数据前后读取的结果不一致（两次读取中有其他事务对该行数据做了修改）
  * **幻读**：某一个事务，对同一个表前后查询到的行数不一致
* 常见的隔离级别
* Read Uncommitted: 读取未提交的数据
* Read Committed: 读取已提交的数据。
* Repeatable Read: 可重复读
* Serializable: 串行化。

![image-20210824162945769](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210824162945769.png)



实现机制

* 悲观锁（数据库）
* 共享锁（S锁）    只能读不能写
  事务A对某数据加了共享锁后，其他事务只能对该数据加共享锁，但不能加排他锁。
* 排他锁（X锁）    不能读不能写
  事务A对某数据加了排他锁后，其他事务对该数据既不能加共享锁，也不能加排他锁。
* 乐观锁（自定义）
* 版本号、时间戳等
  在更新数据前，检査版本号是否发生变化。若变化则取消本次更新，否则就更新数据(版本号+1)



Spring事务管理
- 声明式事务（一般用的）
通过 XML 配置，声明某方法的事务特征。
通过注解，声明某方法的事务特征。（@Transactional）
- 编程式事务（在复杂的问题中管理其中的一小部分）
通过 TransactionTemplate 管理事务，
并通过它执行数据库的操作。



### 3.5 显示评论

数据层
- 根据实体查询一页评论数据。
- 根据实体查询评论的数量。

业务层
- 处理查询评论的业务。
- 处理查询评论数量的业务。

表现层
- 显示帖子详情数据时，同时显示该帖子所有的评论数据。



### 3.6 添加评论

数据层
- 增加评论数据。
- 修改帖子的评论数量。

业务层
- 处理添加评论的业务：
先增加评论、再更新帖子的评论数量。（这里同时处理2个表，要使用**事务**，保证数据的一致性）

表现层
- 处理添加评论数据的请求。
- 设置添加评论的表单。



### 3.7 私信列表

私信列表
- 查询当前用户的会话列表，
每个会话只显示一条最新的私信。
- 支持分页显示。

私信详情
- 查询某个会话所包含的私信。
- 支持分页显示。



### 3.8 发送私信

发送私信
- 采用异步的方式发送私信。
- 发送成功后刷新私信列表。

设置已读
- 访问私信详情时，将显示的私信设置为已读状态。



### 3.9 统一处理异常

@ControllerAdvice
- 用于修饰类，表示该类是 Controller 的全局配置类。
- 在此类中，可以对 Controller 进行如下三种全局配置：
异常处理方案、绑定数据方案、绑定参数方案。

@ExceptionHandler

- 用于修饰方法，该方法会在 Controller 出现异常后被调用，用于处理捕获到的异常。

@ModelAttribute
- 用于修饰方法，该方法会在 Controller 方法执行前被调用，用于为 Model 对象统一绑定参数。

@DataBinder
- 用于修饰方法，该方法会在 Controller 方法执行前被调用，用于绑定参数的转换器。



### 3.10 统一记录日志

#### AOP的概念

- Aspect Oriented Programing
即面向方面（切面）编程。
- AOP 是一种编程思想，是对 OOP 的补充
可以进一步提高编程的效率。

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210826153006938.png" alt="image-20210826153006938" style="zoom:50%;" />

![image-20210826153619973](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210826153619973.png)

target：需要处理的各个 Bean 之类的东西

joinpoint：Bean 中可以被织入的位置

aspect：用来进行统一处理的方面组件

pointcut（切点）：声明要织入什么对象的什么位置

advice：声明处理什么样的逻辑

代理：对原始对象创建代理对象，需要调用时调用代理对象

#### AOP的实现

AspectJ

- AspectJ 是语言级的实现，它扩展了 Java 语言，定义了 AOP 语法。
- AspectJ 在编译期织入代码，它有一个专门的编译器，用来生成遵守 Java 字节码规范的 class 文件。

Spring AOP
- Spring Aop 使用纯 Java 实现，它不需要专门的编译过程，也不需要特殊的类装载器。

- Spring AOP 在运行时通过代理的方式织入代码，只支持方法类型的连接点。

- Spring 支持对 AspecJ 的集成。

  

- JDK 动态代理
  - Java 提供的动态代理技术，可以在运行时创建接口的代理实例。
  - Spring AOP 默认采用此种方式，在接口的代理实例中织入代码。
- CGLib 动态代理
  - 采用底层的字节码技术，在运行时创建子类代理实例。
  - 当目标对象不存在接口时， Spring AOP 会采用此种方式，在子类实例中织入代码。



```java
	@Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
	// 声明处理 execution(所有返回值 com.nowcoder.community.service.所有类.所有方法(所有参数))
    public void pointcut() {

    }

	@Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterRetuning() {
        System.out.println("afterRetuning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        Object obj = joinPoint.proceed();  //通过代理运行目标方法
        System.out.println("around after");
        return obj;
    }

//运行顺序
/*
around before
before
某业务方法
afterRetuning
after
around after
*/
```



## 四、Redis，一站式高性能存储方案

### 4.1 Redis入门

- Redis 是一款基于键值对的 NoSQL 数据库（非关系型数据库），它的值支持多种数据结构：
字符串( strings)、哈希( hashes)、列表( lists)、集合( sets)、有序集合( sorted sets)等。
- Redis 将所有的数据都存放在内存中，所以它的读写性能十分惊人。
同时，Redis 还可以将内存中的数据以**快照**（把整块内存数据存到硬盘里）或**日志**（把执行的每条指令保存到日志里，恢复时就全部重新执行一遍）的形式保存到硬盘上，以保证数据的安全性。
- Redis典型的应用场景包括：缓存、排行榜、计数器、社交网络、消息队列等。

https://redis.Io
https://github.com/microsoftarchive/redis



```java
详细地可以看 https://www.runoob.com/redis/redis-commands.html

//Redis常用命令
平时的变量名像这样：test_cont    Redis中像这样：test:cont

//清空当前数据库中的所有 key
flushdb

//切换到指定的数据库
SELECT index

//返回当前数据库中所有符合要求的 key
keys *
keys test*    前缀带有字符test

//返回 key 所储存的值的类型
TYPE key

//检查给定 key 是否存在
EXISTS key

//在 key 存在时删除 key
DEL key

//为给定 key 设置过期时间，以秒计
EXPIRE key seconds


//字符串（String）操作
#设置指定 key 的值
SET key value

#获取指定 key 的值
GET key

#将 key 中储存的数字值增一
INCR key

#将 key 中储存的数字值减一
DECR key


//哈希表（Hash）操作
field 和 value 都是 string

#将哈希表 key 中的字段 field 的值设为 value
HSET key field value

#获取存储在哈希表中指定字段的值
HGET key field


//列表（List）操作
List可以在头部或者尾部添加元素，里面的元素都是 string

#将一个或多个值插入到列表头部
LPUSH key value1 [value2]

#获取列表长度
LLEN key

#通过索引获取列表中的元素
LINDEX key index

#获取列表指定范围内的元素
LRANGE key start stop

#移除列表的最后一个元素，返回值为移除的元素
RPOP key


//集合（Set）操作
里面的元素都是 string

#向集合添加一个或多个成员
SADD key member1 [member2]

#获取集合的成员数
SCARD key

#移除并返回集合中的一个随机元素
SPOP key

#返回集合中的所有成员
SMEMBERS key


//有序集合(sorted set)操作
里面的元素都是 string。每个元素都会关联一个分数（double类型 score），按score排序

#向有序集合添加一个或多个成员，或者更新已存在成员的分数
ZADD key score1 member1 [score2 member2]

#获取有序集合的成员数
ZCARD key

#返回有序集中，成员的分数值
ZSCORE key member

#返回有序集合中指定成员的索引（排第几名）
ZRANK key member

#通过索引区间返回有序集合指定区间内的成员
ZRANGE key start stop [WITHSCORES]
```



### 4.2 Spring整合Redis

引入依赖
- spring-boot-starter-data-redis

配置 Redis
- 配置数据库参数
- 编写配置类，构造 RedisTemplate

访问 Redis

​	redisTemplate. opsForValue()
​	redisTemplate. opsForHash()
​	redisTemplate. opsForList()
​	redisTemplate. opsForSet()
​	redisTemplate. opsForZSet()

**Redis的事务**

- Redis 的事务是先把事务中的操作指令存到一个队列中，等到提交事务的时候再一块儿发给 Redis 服务器去统一执行
- 所以不要在事务中去做查询操作，要在事务之前或等其提交后再查询
- 因为声明式事务一般是作用于整个方法，不适合 Redis。所以**一般使用编程式事务处理某一段 Redis 操作**

```java
Object obj = redisTemplate.execute(new SessionCallback() {
    @Override
    public Object execute(RedisOperations operations) throws DataAccessException {
        String redisKey = "test:tx";
        
        operations.opsForSet().members(redisKey);  //把查询放到事务外面

        operations.multi(); //事务开始

        operations.opsForSet().add(redisKey, "zhangsan");

        // Redis 的事务是先把事务中的操作指令存到一个队列中，等到提交事务的时候再一块儿发给 Redis 服务器去统一执行。
        // 所以事务中的查询是没有效果的
        System.out.println(operations.opsForSet().members(redisKey));

        return operations.exec(); //事务结束
    }
});
```



### 4.3 点赞

点赞
- 使用 `Redis` 提高性能
- 支持对帖子、评论点赞。
- 第1次点赞，第2次取消点赞。

首页点赞数量
- 统计帖子的点赞数量。

详情页点赞数量
- 统计点赞数量。
- 显示点赞状态。



因为 Redis 的语句和结构相对简单，就不像 MySQL 那样写 mapper，直接在业务层写指令

为了方便处理 Redis 中的一堆 key 名字，创建一个 util 统一管理



使用异步请求



### 4.4 我收到的赞

重构点赞功能
- 以用户为 key，记录点赞数量
- increment(key), decrement(key)

开发个人主页
- 以用户为 key，查询点赞数量



### 4.5 关注、取消关注

需求

- 开发关注、取消关注功能。
- 统计用户的关注数、粉丝数。
- 使用 `Redis` 提高性能

关键
- 若 A 关注了 B，则 A 是 B 的 Follower（粉丝），B 是 A 的 Followee（目标）。
- 关注的目标可以是用户、帖子、题目等，在实现时将这些目标抽象为实体。



### 4.6 关注列表、粉丝列表

业务层
- 査询某个用户关注的人，支持分页。
- 査询某个用户的粉丝，支持分页。

表现层
- 处理“查询关注的人”、“查询粉丝”请求。
- 编写“查询关注的人”、“查询粉丝”模板。



### 4.7 优化登陆模块

使用 Redis 存储验证码
- 验证码需要频繁的访冋与刷新，对性能要求较高。
- 验证码不需永久保存，通常在很短的时间后就会失效。
- 分布式部署时，存在 Session 共享的问题。

使用 Redis 存储登录凭证
- 处理每次请求时，都要查询用户的登录凭证，访问的频率非常高。

使用 Redis 缓存用户信息
- 处理每次请求时，都要根据凭证查询用户信息，访问的频率非常高。
  1. 优先从缓存中取值
  2. 取不到时初始化缓存数据
  3. 数据变更时清除缓存数据



`@Deprecated` 注解声明某个组件不推荐使用（废弃）



## 五、Kafka，构建TB级异步消息系统

### 5.1 阻塞队列

BlockingQueue
- 解决线程通信的问题。Java自带的接口，相比 Kafka 更简单原始，但也能实现功能
- 阻塞方法：put、take

生产者消费者模式
- 生产者：产生数据的线程。把队列 put 满了之后就等待，不会占用cpu资源
- 消费者：使用数据的线程。把队列 take 完了之后就等待，不会占用cpu资源
- 如果两者不通过队列，直接连接的话，处理快的那个线程就会不停发请求，占用cpu资源

实现类
- ArrayBlockingQueue
LinkedBlockingQueue
PriorityBlockingQueue、SynchronousQueue、DelayQueue 等。

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210829150503715.png" alt="image-20210829150503715" style="zoom:50%;" />

这里是**点对点模式**，生产的一堆东西，其中的每一个只能被某一个消费者拿走



### 5.2 Kafka入门

Kafka简介
- Kafka是一个分布式的流媒体平台。
- 应用：消息系统、日志收集、用户行为追踪、流式处理。

Kafka特点
- 高吞吐量、消息持久化（数据存到硬盘里，硬盘的顺序读写速度还是挺快的）、高可靠性（可以做分布式集群部署）、高扩展性。
- **发布订阅模式**。生产的一堆数据，放到某个地方，每个数据都可以被许多消费者获取，但一个数据最终只能被某个抢到它的消费者用掉

Kafka术语
- Broker（Kafka的服务器）、Zookeeper（Kafka内置的用来管理集群的第三方软件）
- Topic（生产者发布的消息的位置空间）、Partition（对Topic的分区）、Offset（消息在分区中的索引）
- Leader Replica（主副本）、Follower Replica（从副本，是对主副本的备份）

http://kafka.apache.org

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210829162154421.png" alt="image-20210829162154421" style="zoom:67%;" />

### 5.3 Spring整合Kafka

引入依赖
- spring-kafka

配置 Kafka
- 配置 server、consumer

访问 Kafka
- 生产者
  `kafkaTemplate. send(topic, data);`

- 消费者
  ```java
  @KafkaListener (topics = {"test"}) //表示监听某些 topic
  public void handleMessage(ConsumerRecord record) {}
  ```



### 5.4 发送系统通知

触发事件
- 评论后，发布通知
- 点赞后，发布通知
- 关注后，发布通知。这些操作都很频繁

处理事件
- 封裝事件对象
- 开发事件的生产者
- 开发事件的消费者

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210830134605488.png" alt="image-20210830134605488" style="zoom: 50%;" />

```java
public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

//在构造类的 `getter`、`setter` 方法中的 setter 的时候返回 this，就可以做到类似下面这样的实例化。可以加任意个set

Event event = new Event()
                .setTopic(TOPIC_COMMENT)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(comment.getEntityType())
                .setEntityId(comment.getEntityId())
                .setData("postId", discussPostId);
```



### 5.5 显示系统通知

通知列表
- 显示评论、点赞、关注三种类型的通知

通知详情
- 分页显示某一类主题所包含的通知

未读消息
- 在页面头部显示所有的未读消息数量



## 六、Elasticsearch，分布式搜索引擎

### 6.1 Elasticsearch入门

Elasticsearch简介
- 一个分布式的、Restful 风格（规定前后端接口、对HTTP请求标准的描述）的搜索引擎。
- 支持对各种类型的数据的检索。
- 搜索速度快，可以提供实时的搜索服务。
- 便于水平扩展，每秒可以处理PB级海量数据。
- 实际上就是把数据都扔进这个里面形成特殊的数据库，再在数据库里面查

Elasticsearch术语
- 索引、类型、文档（一般是json）、字段。
  - 对应于MySQL的 数据库、表、行、列
  - 6.0之后把索引对应到表，类型设为固定值；7.0之后废弃了类型
- 集群、节点、分片、副本。
  - 上面四个词的含义：服务器分布式部署、集群中的某台服务器、对索引进行划分来存、对分片的备份

https://www.elastic.co

[medcl/elasticsearch-analysis-ik: 一个分词插件（把一句话中的各个中文词分开来）](https://github.com/medcl/elasticsearch-analysis-ik)

[Postman API Platform 模拟HTTP请求的软件](https://www.postman.com/)



### 6.2 Spring整合Elasticsearch

引入依赖
- spring-boot-starter-data-elasticsearch

配置 Elasticsearch
- cluster-name、cluster-nodes

Spring Data Elasticsearch
- ~~ElasticsearchTemplate 实现了增删改查方法~~

- ~~ElasticsearchRepository 依赖于前一个Template，要声明子接口来调用，一般更方便~~

- 上面两个已弃用。改用 ElasticsearchOperations 或者 ElasticsearchRestTemplate（实现了ElasticsearchOperations）

  `Usage of the ElasticsearchTemplate is deprecated as of version 4.0, use ElasticsearchRestTemplate instead.`



Elasticsearch 和 Redis 都依赖于netty，而 Elasticsearch 默认没有考虑多个组件依赖于netty的问题，会报错。所以在spring最开始的 CommunityApplication 加入以下代码

```java
	@PostConstruct
    public void init() {
        // 解决netty启动冲突问题
        // see Netty4Utils.setAvailableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
```



为了自动把各类数据放进 Elasticsearch，要在各 entity 加上注解

```java
// 在类的开头加上注解，不过这个注解的后三个参数好像在新版被废弃了
//         索引                       类型           分片         副本
@Document(indexName = "discusspost", type = "_doc", shards = 6, replicas = 3)


// 在类中的各个变量加上注解
	@Id
    private int id;

    @Field(type = FieldType.Integer)
    private int userId;
	//                            存储时分词器              搜索时分词器
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String content;

    @Field(type = FieldType.Integer)
    private int type;

    @Field(type = FieldType.Integer)
    private int status;

    @Field(type = FieldType.Date)
    private Date createTime;

    @Field(type = FieldType.Integer)
    private int commentCount;

    @Field(type = FieldType.Double)
    private double score;
```



### 6.3 开发社区搜索功能

搜索服务
- 将帖子保存至 Elasticsearch 服务器。
- 从 Elasticsearch 服务器删除帖子。
- 从 Elasticsearch 服务器搜索帖子

发布事件
- 发布帖子时，将帖子异步的提交到 Elasticsearch 服务器。

- 增加评论时，将帖子异步的提交到Elasticsearch 服务器。

  因为对帖子做评论的时候，帖子数据库的评论数量字段变了，所以要重新把帖子提交到elasticsearch

- 在消费组件中增加一个方法，消费帖子发布事件。

显示结果
- 在控制器中处理搜索请求，在HTML上显示搜索结果。



## 七、构建安全高效的企业服务

### 7.1 Spring Security

简介
- Spring Security是一个专注于为ava应用程序提供身份认证和授权的框架，它的强大之处在于它可以轻松扩展以满足自定义的需求。

特征
- 对身份的**认证**和**授权**提供全面的、可扩展的支持。
- 防止各种攻击，如会话固定攻击、点击劫持、csrf 攻击等
- 支持与 Servlet API、 Spring MVC 等 Web 技术集成。

https://spring.io/projects/spring-security



DispatcherServlet 发放请求给各个 Controller 处理，Interceptor 可以拦截请求

DispatcherServlet 符合 JavaEE 标准。Filter 不属于 Spring MVC，但符合 JavaEE 标准，可以用来拦截 DispatcherServlet。

Spring Security 底层是Filter 

![image-20210901153109499](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210901153109499.png)




```java
//1. 在User实现以下
	// true: 账号未过期.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // true: 账号未锁定.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // true: 凭证未过期.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // true: 账号可用.
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities();

//2. 在UserService实现以下
	@Override
    public UserDetails loadUserByUsername(String username);

//3. 实现配置类
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter;

    
//4. 其他controller可能需要的一些改动
// 比如 HomeController 加一个拒绝访问时的提示页面之类的
```



### 7.2 权限控制

登录检查
- 之前采用拦截器实现了登录检査，这是简单的权限管理方案，现在将其废弃。

授权配置
- 对当前系统内包含的所有的请求，分配访问权限(普通用户、版主、管理员)。

认证方案
- 绕过 Security认证流程，采用系统原来的认证方案。

CSRF配置
- 防止 CSRF 攻击的基本原理，以及表单、AJAX相关的配置。
  - CSRF 攻击：某网站盗取你的cookie，模仿你的身份访问其他网站服务器并提交表单数据(post)
  - 防止 CSRF 攻击的基本原理：服务器在发给你的表单中隐藏一个token，窃贼只有窃取的cookie而没有表单中的token的话，他提交的post是无效的
  - 对于异步的请求，比如发帖，提交的是json字符串不是表单，不会自动生成token。可以在某处（比如网页开头）强制生成一个csrf.token，发请求时带上



### 7.3 置顶、加精、删除

功能实现
- 点击置顶，修改帖子的类型。
- 点击“加精”、“删除”，修改帖子的状态。

权限管理
- 版主可以执行“置顶”、“加精”操作。
- 管理员可以执行“删除”操作。

按钮显示
- 版主可以看到“置顶”、“加精”按钮。
- 管理员可以看到“删除”按钮。



nowcoder开头的几个用户是管理员或者版主，密码都是123456



### 7.4 Redis高级数据类型

HyperlogLog（超级日志）
- 采用一种基数算法，用于完成独立总数的统计（比如统计有多少不重复的用户访问了网站）。
- 占据空间小，无论统计多少个数据，只占12K的内存空间。
- 不精确的统计算法，标准误差为0.81%。

Bitmap（位图）
- 不是一种独立的数据结构，实际上就是字符串。
- 支持按位存取数据，可以将其看成是byte数组。
- 适合存储索大量的连续的数据的布尔值（比如用户每天是否签到）。



两者都适合用来统计网站数据



### 7.5  网站数据统计

UV ( Unique Visitor)
- 独立访客，需通过用户 IP 排重统计数据。
- 每次访问都要进行统计。
- HyperlogLog，性能好，且存储空间小。

DAU (Daily Active User)
- 日活跃用户，需通过用户 ID 排重统计数据。
- 访问过一次，则认为其活跃。
- Bitmap，性能好、且可以统计精确的结果。



### 7.6 任务执行和调度

JDK线程池
- ExecutorService
- ScheduledExecutorService

Spring线程池
- ThreadPoolTaskExecutor
- ThreadPoolTaskScheduler 
  - **分布式部署时**的定时任务**一般不用**这个和 JDK 自带的，这个和 JDK 自带的的数据存在各自的内存里，多台服务器可能引起冲突
- 使用方法：
  - 在 ThreadPoolConfig 声明 `@Configuration、@EnableScheduling、@EnableAsync`
  - 在普通的方法声明 `@Async`，让该方法在多线程环境下,被异步的调用.
  - 在普通的方法声明 `@Scheduled(initialDelay = 10000, fixedRate = 1000)`，定时任务自动执行

分布式定时任务
- Spring Quartz
  - Quartz 使用的数据资源存在数据库里，多台服务器使用不会引起冲突
  - 使用方法：
    - 通过 Job 接口定义任务，通过 JobDetail 和 Trigger 接口来配置 Job

http://www.quartz-scheduler.org



在 @Test 中写多线程相关的东西时要加个 Thread.sleep 把 test 主线程阻塞一下，不然多线程还没跑完，test 主线程就结束了



**BeanFactory** 是 IoC（面向对象编程的设计思想）容器的顶层接口，是用于依赖注入的

**FactoryBean** 可简化 Bean 的实例化过程:
       1. 通过FactoryBean封装Bean的实例化过程.
    2. 将FactoryBean装配到Spring容器里.
    3. 将FactoryBean注入给其他的Bean.
    4. 该Bean得到的是FactoryBean所管理的对象实例.



### 7.7 热帖排行

![image-20210902164939774](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210902164939774.png)

用定时任务来算，把分数有变化的帖子扔进缓存redis，然后每隔一定时间一块儿算



### 7.8 生成长图

wkhtmltopdf
- wkhtmltopdf url file  这个工具有两条命令
- wkhtmltoimage url file

Java
- Runtime.getRuntime().exec("命令的字符串形式")  在 Java 中用这个去执行上面 wk 的命令
- 这种方式执行命令是**异步**的，即调用这个方法后把命令传给系统，让操作系统去慢慢执行，自己直接继续运行下面的代码

https://wkhtmltopdf.org



### 7.9 将文件上传至云服务器

客户端上传
- 客户端将数据提交给云服务器，并等待其响应。
- 用户上传头像时，将表单数据提交给云服务器。

服务器直传
- 应用服务器将数据直接提交给云服务器，并等待其响应。
- 分享时，服务端将自动生成的图片，直接提交给云服务器。



### 7.10  优化网站的性能

本地缓存
- 将数据缓存在应用服务器上，性能最好。
  - 和用户息息相关的信息（比如登录状态）不要用本地缓存，因为做负载均衡后发到不同服务器的请求应该确保用户登录状态一致
  - 和用户没有强关联的可以用本地缓存（比如热帖数据）
- 常用缓存工具：Ehcache、Guava、Caffeine等。

分布式缓存
- 将数据缓存在 NoSQL 数据库上，跨服务器。
- 常用缓存工具：MemCache、Redis 等。

多级缓存
- `>` 一级缓存（本地缓存）`>` 二级缓存（分布式缓存）`>` DB
- 避免缓存雪崩（缓存失效，大量请求直达DB），提高系统的可用性。

<img title="多服务器分布式部署情况" src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210903213952333.png" alt="image-20210903213952333" style="zoom: 67%;" />

<img title="多级缓存" src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210903214637796.png" alt="image-20210903214637796" style="zoom: 67%;" />

本次使用 Caffeine 和 Redis 对热帖做缓存

* Caffeine核心接口: Cache, 
  * 子接口 LoadingCache（同步缓存，如果有多线程访问同一个缓存中没有的东西，会让线程都等着，从DB中取来之后一个一个给排队的线程）一般用的多
  * 子接口 AsyncLoadingCache（异步缓存，可以同时取数据）不常用

因为可能需要对不同的东西做不同的缓存设置，所以这里不用 spring 对过期时间等做统一整合



## 八、项目部署与总结

### 8.1 单元测试

Spring Boot Testing
- 依赖： spring-boot- starter-test
- 包括： Junit、 Spring Test、 AssertJ、…

Test Case
- 要求：保证测试方法的独立性。
  - 因为以后对数据库或者代码做了修改之后可能还要用同一个 Test Case 来测试
- 步骤：初始化数据、执行测试代码、验证测试结果、清理测试数据。
- 常用注解： 
  - @BeforeClass：初始化测试类之前运行一次
  - @AfterClass：销毁测试类之后运行一次
  - @Before：调用任意测试方法之前运行一次
  - @After：调用任意测试方法之后运行一次



### 8.2 项目监控

Spring Boot Actuator
- Endpoints：监控应用的入口，Spring Boot 内置了很多端点，也支持自定义端点。
- 监控方式：HTTP 或 JMX.
- 访问路径：例如"/actuator/health"
- 注意事项：按需配置暴露的端点，并对所有端点进行权限控制。



### 8.3 项目部署

![image-20210904161503468](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210904161503468.png)

![image-20210904213003180](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210904213003180.png)



**注意centos防火墙有没有开放端口**

```
开启端口
firewall-cmd --zone=public --add-port=80/tcp --permanent

查询端口号80 是否开启：
firewall-cmd --query-port=80/tcp

重启防火墙：
firewall-cmd --reload

查询有哪些端口是开启的:
firewall-cmd --list-port
```



**Nginx的connect() to 127.0.0.1:8080 failed (13: Permission denied) while connect**

在进行Nginx+Tomcat 负载均衡的时候遇到了这个权限问题，在error.log日志中，我们可以看到如下：
```
 connect() to 127.0.0.1:8080 failed (13: Permission denied) while connecting to upstream,
```
经过一番检查以及google,应该是SeLinux的导致的。可以选择一些两种方式进行：

1、关闭SeLinux,可以查看以下文章：

[CentOS下查看SeLinux状态及关闭SeLinux](http://www.osheep.cn/824.html)

2、执行下面的命令
```
setsebool -P httpd_can_network_connect 1
```



**注意服务器上的和开发时的spring里的Tomcat的大版本一定要对上**



### 8.4 项目总结

![image-20210905152235172](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905152235172.png)

![image-20210905154603317](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905154603317.png)

一般静态资源是买CDN来存放，动态资源走 nginx 分发给服务器



### 8.5 重要知识

1. MySQL
存储引擎、事务、锁、索引

2. Redis
数据类型、过期策略、淘汰策略、缓存穿透、缓存击穿、缓存雪崩、分布式锁

3. Spring
Spring IoC、Spring AOP、Spring MVC



#### **MySQL 锁**

**范围**

- 表级锁：开销小、加锁快，发生锁冲突的概率高、并发度低，不会出现死锁。
- 行级锁：开销大、加锁慢，发生锁冲突的概率低、并发度高，会出现死锁。

**类型 (InnoDB)**

- 共享锁(S)：行级，读取一行时使用，别人可以读不能写；
- 排他锁(X)：行级，更新一行时使用，别人不能读不能写；
- 意向共享锁(IS)：表级，准备加共享锁；
- 意向排他锁(IX)：表级，准备加排他锁；
- 间隙锁(NK)：行级，使用范围条件时，对范围内不存在的记录加锁。一是为了防止幻读，二是为了满足恢复和复制的需要。
  - 比如查询id大于100的，实际只有101和102，但对103、104等也加锁

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905155842796.png" alt="image-20210905155842796" style="zoom:67%;" />

表格第一行表示：某人加了IS准备读时，其他人可以加IS、IX、S，不能加X来写



**加锁**

- 增加行级锁之前， InnoDB会自动给表加意向锁；
- 执行DML（数据操纵语言）语句时， InnoDB会自动给数据加排他锁；
- 执行DQL（数据查询语言）语句时，大多需要自己加
共享锁(S)：SELECT … FROM … WHERE … LOCK IN SHARE MODE;
排他锁(x)：SELECT … FROM … WHERE … FOR UPDATE；
间隙锁(NK):上述SQL采用范围条件时， InnoDB 对不存在的记录自动增加间隙锁。



**死锁**

场景

事务1: UPDATE T SET … WHERE ID=1; UPDATE T SET … WHERE ID = 2;
事务2: UPDATE T SET … WHERE ID=2; UPDATE T SET … WHERE ID = 1;

解决方案

1. 一般 InnoDB 会自动检测到，并使一个事务回滚，另一个事务继续；
2. 设置超时等待参数 innodb_lock_wait_timeout；

避免死锁

1. 不同的业务并发访问多个表时，应约定以相同的顺序来访问这些表；
2. 以批量的方式处理数据时，应事先对数据排序，保证线程按固定的顺序来处理数据；
3. 在事务中，如果要更新记录，应直接申请足够级别的锁，即排他锁（不要先申请共享锁，再升级到排他锁）；



**悲观锁（数据库自动的）**
**乐观锁（自定义）**

1. 版本号机制
UPDATE … SET …, VERSION=#{version+1} WHERE … AND VERSION=${version}
2. CAS算法 (Compare and swap)
    是一种无锁的算法，该算法涉及3个操作数(内存值V、旧值A、新值B)，当V等于A时，采用原子方式用B的值更新V的值。该算法通常采用自旋操作，也叫自旋锁。它的缺点是：
      * ABA问题：某线程将A改为B,再改回A,则CAS会误认为A没被修改过。
      * 自旋操作采用循环的方式实现，若加锁时间长，则会给CPU带来巨大的开销。
      * CAS只能保证一个共享变量的原子操作。



#### **MySQL 索引**

B+Tree (InnoDB)
- 数据分块存储，每一块称为一页；
- 所有的值都是按顺序存储的，并且每一个叶子到根的距离相同；
- 非叶节点存储数据的边界，叶子节点存储指向数据行的指针；
- 通过边界缩小数据的范围，从而避免全表扫描，加快了査找的速度。

![tmp97DE](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/tmp97DE.png)

#### **Redis**

**数据类型**

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905163520448.png" alt="image-20210905163520448" style="zoom: 50%;" />

**过期策略**

Redis会把设置了过期时间的key放入一个独立的字典里，在key过期时并不会立刻删除它。
Redis会通过如下两种策略，来删除过期的key：
- 惰性删除
客户端访问某个key时，Redis会检查该key是否过期，若过期则删除。
- 定期扫描
	Redisa默认每秒执行10次过期扫描(配置hz选项)，扫描策略如下：
	1. 从过期字典中随机选择20个key
	2. 删除这20个key中已过期的key
	3. 如果过期的key的比例超过25%，则重复步骤1

**淘汰策略**

当 Redis占用内存超出最大限制 (maxmemory) 时，可采用如下策略( maxmemory- policy)，让 Redisi淘汰一些数据，以腾出空间继续提供读写服务：
- noeviction：对可能导致增大内存的命令返回错误(大多数写命令，DEL除外)；
- volatile-ttl：在设置了过期时间的key中，选择剩余寿命(TTL)最短的key，将其淘汰；
- volatile-lru：在设置了过期时间的key中，选择最少使用的key(LRU)，将其淘汰；
- volatile-random：在设置了过期时间的key中，随机选择一些key，将其淘汰；
- allkeys-lru：在所有的key中，选择最少使用的key(LRU)，将其淘汰；
- allkeys-random：在所有的key中，随机选择一些key，将其淘汰



LRU算法
	维护一个链表，用于顺序存储被访过的key。在访问数据时，最新访问过的key将被移动到表头，即最近访可的key在表头，最少访问的key在表尾

近似LRU算法（Redis）
	给每个key维护一个时间戳，淘汰时随机采样5个key，从中淘汰掉最旧的key。如果还是超出内存限制，则继续随机采样淘汏。
	优点：比LRU算法节约内存，却可以取得非常近似的效果。



**缓存穿透**

场景
	查询根本不存在的数据，使得请求直达存储层，导致其负载过大，甚至宕机。

解决方案
1. 缓存空对象
存储层未命中后，仍然将空值存入缓存层。再次访问该数据时，缓存层会直接返回空值
2. 布隆过滤器
将所有存在的key提前存入布隆过滤器，在访问缓存层之前，先通过过滤器拦截，若请求的是不存在的key，则直接返回空值。

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905165430032.png" alt="image-20210905165430032" style="zoom:50%;" />

**缓存击穿**

场景
一份热点数据，它的访问量非常大。在其缓存失效瞬间，大量请求直达存储层，导致服务崩溃。

解决方案
1. 加互斥锁
对数据的访问加互斥锁，当一个线程访问该数据时，其他线程只能等待。
这个线程访问过后，缓存中的数据将被重建，届时其他线程就可以直接从缓存取值。
2. 永不过期
不设置过期时间，所以不会出现上述问题，这是“物理”上的不过期。
或者 为每个 value 设置逻辑过期时间，当发现该值逻辑过期时，使用单独的线程重建缓存。

**缓存雪崩**

场景
由于某些原因，缓存层不能提供服务，导致所有的请求直达存储层，造成存储层宕机。

解决方案
1. 避免同时过期
设置过期时间时，附加一个随机数，避免大量的key同时过期。
2. 构建高可用的 Redis 缓存
部署多个 Redis 实例，个别节点宕机，依然可以保持服务的整体可用。
3. 构建多级缓存
增加本地缓存，在存储层前面多加一级屏障，降低请求直达存储层的几率。
4. 启用限流和降级措施
对存储层增加限流措施，当请求超出限制时，对其提供降级服务（比如返回默认值和空值）。



**分布式锁**

场景
	修改时，经常需要先将数据读取到内存，在内存中修改后再存回去。在分布式应用中，可能多个进程同时执行上述操作，而读取和修改非原子操作，所以会产生冲突。增加分布式锁，可以解决此类问题。

基本原理
同步锁：在多个线程都能访问到的地方，做一个标记，标识该数据的访问权限。
分布式锁：在多个进程（多个server）都能访问到的地方（不能放在server内存），做一个标记，标识该数据的访问权限。

实现方式
1. 基于数据库实现分布式锁；
2. 基于 Redis 实现分布式锁，通常放 Redis 里；
3. 基于 zookeeper 实现分布式锁；

Redis 实现分布式锁的原则
1. 安全属性：独享。在任一时刻，只有一个客户端持有锁。
2. 活性A：无死锁。即便持有锁的客户端崩溃或者网络被分裂，锁仍然可以被获取。
3. 活性B：容错。只要大部分 Redis 节点都活着，客户端就可以获取和释放锁。

<img src="https://cdn.jsdelivr.net/gh/light-307/pic@main/image/tmp4721.png" alt="tmp4721" style="zoom: 50%;" />

![tmp8B7B](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/tmp8B7B.png)



#### **Spring IoC**

Bean 的作用域

![image-20210905173308091](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905173308091.png)

#### **Spring MVC**

![image-20210905173710098](https://cdn.jsdelivr.net/gh/light-307/pic@main/image/image-20210905173710098.png)

HandlerMapping：查找对应的 controller

HandlerExecutionChain：封装了找到的对应的 controller 和 拦截器

preHandle()：拦截器的 preHandle 方法

HandlerAdapter：controller 封装在这个里面

postHandle()：拦截器的 postHandle 方法

ViewResolver：视图解析器

afterCompletion()：拦截器的 afterCompletion 方法










-----------------

结束

![](https://cdn.jsdelivr.net/gh/light266/pic@main/study/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201221162358.png)