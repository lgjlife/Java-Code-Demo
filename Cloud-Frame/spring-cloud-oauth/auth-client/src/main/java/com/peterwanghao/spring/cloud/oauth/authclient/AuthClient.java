package com.peterwanghao.spring.cloud.oauth.authclient;

import com.peterwanghao.spring.cloud.oauth.authclient.filters.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**   
 * @ClassName:  Application
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午3:21:27
 * @version V1.0
 * 
 */
@EnableGlobalMethodSecurity(prePostEnabled=true)
@SpringBootApplication
public class AuthClient {
	public static void main(String[] args) {
        SpringApplication.run(AuthClient.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    } 
}
