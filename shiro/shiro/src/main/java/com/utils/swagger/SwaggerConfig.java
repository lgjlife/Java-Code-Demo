package com.utils.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2                // Swagger的开关，表示已经启用Swagger
@Configuration                 // 声明当前配置类
public class SwaggerConfig {

    @Value("${swagger.title}")
    private String  title;
    @Value("${swagger.version}")
    private String  version;
    @Value("${swagger.contactName}")
    private String  contactName;
    @Value("${swagger.contactUrl}")
    private String  contactUrl;
    @Value("${swagger.description}")
    private String  description;

    @Value("${swagger.basePackage}")
    private String  basePackage;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }
        //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    //页面标题
                    .title(title)
                    //创建人
                    .contact(new Contact(contactName, contactUrl, ""))
                    //版本号
                    .version(version)
                    //描述
                    .description(description)
                    .build()
                    ;
        }

}