<h1>Spring Boot War 打包发布</h2>

<h3>修改pom文件中的packaging</h3>

```
  <packaging>war</packaging>
  
```

<h3>修改Spring Boot 启动类</h3>

此时就该Spring Boot出马了。它提供的SpringBootServletInitializer是一个支持Spring Boot的Spring WebApplicationInitializer实现。除了配置Spring的DispatcherServlet， SpringBootServletInitializer还会在Spring应用程序上下文里查找Filter、Servlet或ServletContextInitializer类型的Bean，把它们绑定到Servlet容器里。要使用SpringBootServletInitializer，只需创建一个子类，覆盖configure()方法
来指定Spring配置类。
这里使Application继承SpringBootServletInitializer.

原来的

```
@MapperScan(basePackages = "com.dao.mapper")
@SpringBootApplication
public class Application   {

    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
}
```

修改后

```
@MapperScan(basePackages = "com.dao.mapper")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
       // log.info("执行主线程");
        SpringApplication.run(Application.class, args);
    }
}
```

<h3>配置打包执行指令</h3>
使用的指令是

```
mvn package

```

如果已经安装了Maven,可以cd进入项目目录（pom.xml所在目录）

这里使用IDEA的内置的Maven来实现。
<ol>
    <li>添加一个Maven配置</li>
    <li>Wborkingdirectory 选择的是pom.xml所在目录</li>
    <li>Command Line 写入 package,不需要mvn.可以加-e 或者 -f ,会输出打包过程中的错误和所有信息</li>
    <li>执行上述打包配置</li>
    <li>在工程target目录下生成一个.war文件，这个就是要发布到服务器的文件。这里输出的是demo-0.0.1-SNAPSHOT.war</li>
</ol>

![配置](https://github.com/Mrlgj/SpringBootStudy/blob/master/ch8/img/1.png)
![输出](https://github.com/Mrlgj/SpringBootStudy/blob/master/ch8/img/2.png)

<h3>发布到Tomcat</h3>
这里使用的是Tomcat服务器。
<ol>
    <li>将上述的war文件复制到Tomcat目录下的webapps文件夹下。</li>
    <li>重启Tomcat,Tomcat会将war文件展开为普通文件夹。</li>
    <li>输入网址进行访问，如果没有对war文件进行改名，则访问路径是，http://localhost:8080/demo-0.0.1-SNAPSHOT/xxxx/xxxx/xxx，
        如果改名就将路径中的demo-0.0.1-SNAPSHOT改为新名字即可。</li>
</ol>
