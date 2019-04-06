package com.cloud.frame.oauth2.server.config;

import com.cloud.frame.common.bean.FilterIgnorePropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-10 17:32
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("url 配置");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1")
                               .password("123456")
                               .authorities("USER")
                                .roles("USER")
                               .build());
        manager.createUser(User.withUsername("user2")
                .password("123456")
                .authorities("USER")
                .roles("USER")
                .build());
        auth.userDetailsService(manager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .requestMatchers().anyRequest()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/auth/sumit")

                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();

        System.out.println("url 配置");
        filterIgnorePropertiesConfig.getUrls().forEach(url -> System.out.println(url));
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                exp =  http.authorizeRequests();
        filterIgnorePropertiesConfig.getUrls().forEach(url ->   exp.antMatchers(url).permitAll());

        exp.anyRequest().authenticated();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
