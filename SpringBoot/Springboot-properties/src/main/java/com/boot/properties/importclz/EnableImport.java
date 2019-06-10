package com.boot.properties.importclz;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DeferredImportSelectorImpl.class,ImportBeanDefinitionRegistrarImpl.class,
        ImportSelectorImpl.class,NullImpl.class})
public @interface EnableImport {

    String address();
    /**
     context = null
     ImportSelectorImpl selectImports........
     ImportSelectorImpl = null
     DeferredImportSelectorImpl selectImports.....
     ImportBeanDefinitionRegistrarImpl registerBeanDefinitions.......
     2019-05-11 10:23:49.288  INFO 6630 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
     2019-05-11 10:23:49.375  INFO 6630 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
     2019-05-11 10:23:49.377  INFO 6630 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.17]
     2019-05-11 10:23:49.627  INFO 6630 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
     2019-05-11 10:23:49.628  INFO 6630 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3156 ms
     properties = AllConfigurationProperties(name=libai, other=OtherProperties(id=100, version=1.0.1), aserver=[127.0.0.1, 127.0.0.2, 127.0.0.3], list=[111, 222, 333], map={key1=value1, key2=value2, key3=value3}, modules={key1=ModuleConfig(name=modules-name-1, version=modules-version-1, owner=modules-owner-1), key2=ModuleConfig(name=modules-name-2, version=modules-version-2, owner=modules-owner-2)}, modulesList=[ModuleConfig(name=modules-name-3, version=modules-version-3, owner=modules-owner-3), ModuleConfig(name=modules-name-4, version=modules-version-4, owner=modules-owner-4)])
     context = org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@5e82df6a, started on Sat May 11 10:23:46 CST 2019
     NullImpl init....
     NullImpl = AllConfigurationProperties(name=libai, other=OtherProperties(id=100, version=1.0.1), aserver=[127.0.0.1, 127.0.0.2, 127.0.0.3], list=[111, 222, 333], map={key1=value1, key2=value2, key3=value3}, modules={key1=ModuleConfig(name=modules-name-1, version=modules-version-1, owner=modules-owner-1), key2=ModuleConfig(name=modules-name-2, version=modules-version-2, owner=modules-owner-2)}, modulesList=[ModuleConfig(name=modules-name-3, version=modules-version-3, owner=modules-owner-3), ModuleConfig(name=modules-name-4, version=modules-version-4, owner=modules-owner-4)])

     */
}
