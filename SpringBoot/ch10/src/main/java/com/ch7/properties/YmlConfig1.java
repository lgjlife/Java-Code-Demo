package com.ch7.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @program: swagger
 * @description: 读取yml文件实例
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-01 16:49
 **/

@Configuration
public class YmlConfig1 {

    /*
testyml:
  simpleProp: simplePropValue
  arrayProps: 1,2,3,4,5
  listProp1:
    - name: abc
      value: abcValue
    - name: efg
      value: efgValue
  listProp2:
    - config2Value1
    - config2Vavlue2
  mapProps:
    key1: value1
     */
    @Value("${testyml.simpleProp}")
    private  String simpleProp;

    @Value("${testyml.arrayProps}")
    private  String[] arrayProps;

    //@Value("${testyml.listProp1}")
    private  List<Map<String,String>> listProp1 = new ArrayList< >();

   // @Value("${testyml.listProp2}")
    private  List<String> listProp2 = new ArrayList<String>();

   //  @Value("${testyml.mapProps}")
    private  Map<String,String> mapProps = new HashMap<String, String>();

    @Value("${testyml.mapProps.key1}")
    private  String key1;
/*
spring:
  redis:
    #host地址
    host: 127.0.0.1
    #端口
    port: 6379
    jedis:
      pool:
        #最大连接数 0表示无限制
        max-active: 8
        #最大空闲处
        max-idle: 100
        #最大等待时间
        max-wait: 1000ms
        #连接池中的最小空闲连接
        min-idle: 0
 */
    //#最大连接数 0表示无限制
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private Integer redisPort;
    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;
    //        #最大空闲处
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    //          #最大等待时间
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String maxWait;
    //#连接池中的最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;

//    spring:
//    datasource:
//    name: mysqldatasource
//    url: jdbc:mysql://localhost:3306/lanmei?characterEncoding=utf-8
//    username: root
//    password: 563739007
//            # type: com.alibaba.druid.pool.DruidDataSource
//    driver-class-name: com.mysql.jdbc.Driver

    @Value("${spring.datasource.name}")
    private String dataSourceName;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.password}")
    private String dataSourcePasswrd;
    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceClassName;


   @Bean
   public YmlConfig1 ymlConfig1Bean(){
       return new YmlConfig1();
   }

    @Override
    public String toString() {
        return "YmlConfig1{" +
                "simpleProp='" + simpleProp + '\'' +
                ", arrayProps=" + Arrays.toString(arrayProps) +
                ", listProp1=" + listProp1 +
                ", listProp2=" + listProp2 +
                ", mapProps=" + mapProps +
                ", key1='" + key1 + '\'' + "\r\n" +
                ", redisHost=" + redisHost +
                ", redisPort=" + redisPort +
                ", maxActive=" + maxActive +
                ", maxIdle=" + maxIdle +
                ", maxWait='" + maxWait + '\'' +
                ", minIdle=" + minIdle +   "\r\n" +
                ", dataSourceName='" + dataSourceName + '\'' +
                ", dataSourceUrl='" + dataSourceUrl + '\'' +
                ", dataSourcePasswrd='" + dataSourcePasswrd + '\'' +
                ", dataSourceClassName='" + dataSourceClassName + '\'' +
                '}';
    }
}
