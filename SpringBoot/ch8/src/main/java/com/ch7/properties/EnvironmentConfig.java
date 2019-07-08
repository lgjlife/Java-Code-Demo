package com.ch7.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @program:
 * @description: 使用Environment读取配置文件信息
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 11:29
 **/
@Configuration
public class EnvironmentConfig {

    @Autowired
    private Environment env;


    @Bean
    public EnvironmentConfig EnvConfigBean(){
        return new EnvironmentConfig();
    }

    public void  printServerConfig(){
        //port读取到的是-1？？？？？？？？？
        Integer port = env.getProperty("server.port",Integer.class);
        String context_path = env.getProperty("server.servlet.context-path");
        String dir = env.getProperty("user.dir");
        String home = env.getProperty("user.home");
        String javaHome = env.getProperty("JAVA_HOME");

        String env1 = env.getProperty("aaa");
        String env2 = env.getProperty("aaa.bbb");
        String env3 = env.getProperty("aaa.bbb.ccc");



        System.out.println("port = " + port
                + "  context-path = " + context_path
                + "  user.dir = " + dir
                + "  user.home = " + home
                + "  JAVA_HOME = " + javaHome
                + env1 + env2 + env3
        );
    }
}
