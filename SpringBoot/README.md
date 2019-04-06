<h1>SpringBoot 学习记录</h1>
   本项目是关于SpringBoot的相关实例,每一个章节都是一个单独的项目,由于未进行全局的学习规划，所以相关章节顺序未能按照相应模块进行划分，只能想到什么就设计相应的实例。
如您觉得该项目对您有用，欢迎点击右上方的Star按钮，给予支持！！之后有时间了会写相关的博客进行讲解。

</br>


<ul type="disc">
    <li><a href="https://blog.csdn.net/u011676300">我的博客地址</a></li>
    <li><a href="https://github.com/Mrlgj/SpringBootStudy">项目地址</a></li>
    <li>开发环境：IDEA</li>
    <li>项目构建工具：Maven</li>
    <li>SpringBoot版本:2.0.3.RELEASE</li>
    <li>Java版本:JDK 9.0.1</li>
    <li>版本管理：Git</li>
    <li><a href="https://spring.io/projects/spring-boot#learn">Spring Boot官网</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/">Spring Boot参考文档</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/api/">Spring Boot API文档</a></li>
</ul>

注：相关的程序范例都有对应的测试类。

<h3>章节介绍</h3>

<ul type="disc">
    <li>ch1:一个简单的web项目</li>
    <li>
      ch2:使用logback作为日志框架
      <ol>
         <li> <a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch2/src/main/resources/logback-spring.xml">logback配置文件</a> </li>           
      </ol>
    </li>
    <li>
        ch3:数据库操作
        <ol>
            <li>数据库：Mysql </li> 
            <li>使用框架:Mybatis</li>
            <li>使用插件自动生成Mybatis相关代码<a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch3/src/main/resources/generator/generatorConfig.xml">自动生成代码配置文件</a>
            <a href="https://blog.csdn.net/u011676300/article/details/80927390">IDEA自动生成Mybatis代码教程</a>
            </li>           
        </ol>
    </li>
    <li>
        ch4:Junit测试
        <ol>
               <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch4/src/test/java/com/test"> 使用Suite实现一次运行多个实例</a> </li> 
               <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch4/src/test/java/com/serviceImpl"> 服务层Service测试</a></li> 
               <li> MVC层Controller测试（使用MockMvc进行测试）  
                   <a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch4/src/main/java/com/controller">Controller</a>
                   <a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch4/src/test/java/com/controller">Test</a>
                   <ol>
                        <li>匹配路径 普通路径 <code>url</code></li>
                        <li>匹配路径 带参数 <code>url/{xxx}</code></li>
                        <li>匹配路径 通配符  <code>url/*/*  url/**</code></li>
                        <li>匹配Http Method  <code>GET POST DELETE PUT</code></li>
                        <li>请求的媒体类型 consumes</li>
                        <li>响应的媒体类型 produces</li>
                        <li>使用Model</li>
                        <li>使用ModelAndView</li>
                        <li>匹配路径 带参数 <code>url?xxx=xxx</code></li>
                        <li>请求为Json数据,返回也为Json数据</li>
                        <li>文件上传</li>
                  </ol>
               </li>  	       
         </ol>
    </li>
    <li>
        ch5:集成swagger2
        <ol>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch5/pom.xml">swagger 依赖</a></li> 
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch5/src/main/java/com/swagger/SwaggerConfig.java">swagger 配置类</a></li>  
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch5/src/main/java/com/controller/MvcMethodParamController.java">在Controller类和方法上添加注解@Api   @ApiOperation等</a></li> 
            <li>运行项目,访问网址 http://localhost:8080/swagger-ui.html</li>         
        </ol>
    </li>
    <li>
        ch6:集成Redis
        <ol>
           <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch6/src/main/java/com/ch6/redis">Redis</a>
           <ol>
                <li>类库：Spring-data-redis和Jedis</li>
                <li>key序列化：StringRedisSerializer</li>
                <li>value序列化：GenericJackson2JsonRedisSerializer</li>
                <li>注意：使用GenericJackson2JsonRedisSerializer实现序列化,实体类不用实现Serializab接口，但是实体类需要实现set方法，否则会出现反序列化错误.</li>
                <li>Spring-data-redis默认使用JdkSerializationRedisSerialize实现序列化，实体类需要实现Serializab接口，空间效率相对较低。</li>
           </ol>
        </ol>
        <ol>
           <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch6/src/main/java/com/ch6/MongDB">MongDB</a>
        </ol>
    </li>
    <li>
        <a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch7">ch7:SpringBoot 配置相关</a>
        <ol>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch7/src/main/resources/application.yml">
            所有项目使用.yml文件配置，结构更清晰</a></li>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch7/src/main/resources/application.yml">
            配置端口号port和Context-Path</a></li>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch7/pom.xml">
            pom.xml文件中配置使用不同的web容器</a></li>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch7/src/main/java/com/ch7/CreateBean">
                            使用@Configuration和@Bean创建bean</a></li>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch7/src/main/java/com/ch7/properties">
            Java中三种方式获取.yml文件和properties文件的配置</a></li>                
        </ol>
    </li>
    <li>
        ch8:打包发布
        <ol>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch8">war打包,发布至Tomcat</a></li>
        </ol>
    </li>
    <li>
        ch9:AOP实现
        <ol>
            <li>注解式创建切面类</li>
            <li>
             增强类型            
                <ul type="disc">
                    <li>前置增强</li>
                    <li>后置增强</li>
                    <li>异常增强</li>
                    <li>环绕增强</li>
                </ul>
            </li>
            <li>
             匹配切点            
                <ul type="disc">
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/execution">execution</a></li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/args">args</a>存在问题，编译出错</li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/args">@args</a>存在问题，编译出错</li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/within">@target</a>存在问题，编译出错</li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/annotation">@annotation</a></li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/within">within</a></li>
                    <li><a href=""https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/within>@within</a></li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/target">target</a></li>
                    <li><a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch9/src/main/java/com/ch9/This">this</a></li>
                </ul>
            </li>
        </ol>
    </li>
    <li>        
        <a href="https://github.com/Mrlgj/SpringBootStudy/tree/master/ch10">ch10:集成邮件服务</a>
        <ul type="disc">
            <li>普通邮件</li>
            <li>Html邮件</li>
            <li>带附件邮件</li>
            <li>文本中嵌入图片邮件</li>
        </ul>
    </li>
    <li>
        ch11:实现异常统一处理
        <ul type="disc">
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch11/src/main/java/com/ch11/errhandle/GlobalExceptionHandler.java">普通Java异常统一处理</a></li>
            <li><a href="https://github.com/Mrlgj/SpringBootStudy/blob/master/ch11/src/main/java/com/ch11/errhandle/HttpErrorHandle.java">Http请求出错统一处理</a></li>
        </ul>        
    </li>
    <li>
        ch12：集成quartz
        <ul type="disc">
            <li>目前只是添加了基本的实例，后面还需加上动态增删改定时任务。</li>
        </ul>
    </li>
    <li>
        ch13是：使用actuator监控应用
        <ul type="disc">
            <li>使用thymeleaf模板</li>
            <li>前端请求使用Ajax</li>
            <li>前端列表展示，目前只是展示了/actuator和/beans信息</li>
        </ul>
    </li>
</ul>
