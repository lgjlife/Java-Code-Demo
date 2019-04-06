<h1>Spring Boot配置</h1>
<h3>配置文件</h3>
Spring Boot 配置文件有两种形式：

<ul type="disc">
    <li>application.properties</li>
    <li>application.yml</li>
</ul>
application.properties

```
server.port=8080
server.server.context-path=/xx/xx
```
application.yml

```
server:
    port: 8080
    server:
      context-path: /xx/xx
```
可以看出application.yml形式的结构更加清晰。

默认放置的位置
<ul type="disc">
    <li>file: ./config/ </li>
    <li>file: ./ </li>
    <li>classpath:/config </li>
    <li>classpath:/ </li>
</ul>

以上是按照优先级从高到低的顺序，所有位置的文件都会被加载，高优先级的配置内容会覆盖低优先级配置内容.

<h3>server相关配置</h3>

```
server:
   #端口号
  port: 8080
  servlet:
    #配置应用上下文path,默认为"/",更改后访问地址http://localhost:8080/spring/boot/xxx/xxx/xxx
    #
    context-path: /spring/boot
```

<h3>配置不同的容器</h3>

<h6>Tomcat</h6>
Spring Boot默认使用的是Tomcat服务器容器。
添加以下依赖即可
```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

<h6>Undertow</h6>

```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 如果不使用内嵌的tomcat，而是使用其他服务器容器，需要把它排除掉-->
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency> 
<!--使用其他容器，Undertow -->
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-undertow</artifactId>
 </dependency>

 <!--使用其他容器，jetty -->
 <!--
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-jetty</artifactId>
 </dependency>
 -->

```
<h6>Jetty</h6>

```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 如果不使用内嵌的tomcat，而是使用其他服务器容器，需要把它排除掉-->
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency> 

 <!--使用其他容器，jetty -->

 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-jetty</artifactId>
 </dependency>

```
<h3>使用@Configuration和@Bean创建bean</h3>

<h3>Java中三种方式获取.yml文件和properties文件的配置</h3>




                
