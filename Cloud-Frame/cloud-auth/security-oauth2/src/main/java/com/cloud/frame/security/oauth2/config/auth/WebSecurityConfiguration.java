package com.cloud.frame.security.oauth2.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Objects;

/**
 * @program: top-parent
 * @description: Spring Security配置
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 22:12
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnection;

    @Autowired
    CustomUserService customUserService;

    /** 
     * @description:  配置使用内存用户名和密码  
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/23/18 
    */ 
   // @Bean
  //  @Override
    protected UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
        return manager;
    }

    /** 
     * @description: 资源安全配置
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/23/18 
    */ 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问*/




        // @formatter:off
       /* http.logout()
                .logoutUrl("/logout").addLogoutHandler(new OauthLogoutHandler())
            ;*/
        http
            .authorizeRequests()
            .antMatchers("/oauth/*").permitAll()
            ;
        // @formatter:on

      /*  http.authorizeRequests()
                .antMatchers("/login","/logout.do").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login.do")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
                .and()
                .userDetailsService(userDetailsServiceBean());*/

    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

   // @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {

                log.info("charSequence = " + charSequence.toString());
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {

                log.info("charSequence = " + charSequence.toString()
                +  ";  s = "  + s );
                return Objects.equals(charSequence.toString(),s);
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
    }


}
