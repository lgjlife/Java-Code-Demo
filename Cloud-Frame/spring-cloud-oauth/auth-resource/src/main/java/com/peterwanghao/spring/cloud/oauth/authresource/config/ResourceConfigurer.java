package com.peterwanghao.spring.cloud.oauth.authresource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**   
 * @ClassName:  ResourceConfigurer
 * @Description:REST API Resource Server.
 * @author: wanghao
 * @date:   2018年7月19日 下午2:39:35
 * @version V1.0
 * 
 */
@Configuration
@EnableWebSecurity
@EnableResourceServer
public class ResourceConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }

}
