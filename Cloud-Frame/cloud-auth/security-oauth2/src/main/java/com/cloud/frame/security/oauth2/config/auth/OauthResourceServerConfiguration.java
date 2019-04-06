package com.cloud.frame.security.oauth2.config.auth;

import com.cloud.frame.security.oauth2.config.auth.exception.AuthExceptionEntryPoint;
import com.cloud.frame.security.oauth2.config.auth.exception.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 22:14
 **/
@Configuration
@EnableResourceServer
public class OauthResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    /** 
     * @description: 配置认证异常处理 -- 用户名/密码/token 不正确
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/24/18 
    */ 
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint())
                .accessDeniedHandler(customAccessDeniedHandler);

    }

    /** 
     * @description:  配置资源访问权限
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/24/18 
    */ 
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
            // Since we want the protected resources to be accessible in the UI as well we need
            // session creation to be allowed (it's disabled by default in 2.0.6)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .requestMatchers().anyRequest()
            .and()
            .anonymous()
            .and()
            .authorizeRequests()
            .antMatchers("/buy/**").access("hasRole('ROLE_USER')")
          //  .antMatchers("/buy/**").authenticated()
            .antMatchers("/order/**").authenticated()
            //静态资源----------------------------
            .antMatchers("/css/**","/js/**","/bootstrap/**","/jquery/**").permitAll()
            .antMatchers("/login","/logout/do").permitAll()
            .antMatchers("/logout/**").permitAll()
            //配置所有路径的权限，必须放在最后！！！！！！！！！！
            .antMatchers("/**").authenticated()
            //登录----------------------------------
            .and()
            .formLogin()
            //自定义登录页url,默认为/login
            .loginPage("/login")
            //登录请求拦截的url,也就是form表单提交时指定的action
            .loginProcessingUrl("/login/do")
            //用户名的请求字段和密码
            .usernameParameter("username")
            .passwordParameter("password")
          //  .successForwardUrl("/login/success")
            //退出登录----------------------------------
            .and()
            .logout()
            //退出登录请求路径
            .logoutUrl("/logout")
            //退出登录成功后跳转路径 get
            //前后端分离的情况下，不应该用这种方法
            .logoutSuccessUrl("/logout/success")
            //前后端分离的情况下，应该用这种方法
            //.logoutSuccessHandler()
            .invalidateHttpSession(true)
            .deleteCookies("access_token")
            ;
    // @formatter:on

      /*  http.authorizeRequests()
            .antMatchers("/login","/logout/do").permitAll()
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


}
