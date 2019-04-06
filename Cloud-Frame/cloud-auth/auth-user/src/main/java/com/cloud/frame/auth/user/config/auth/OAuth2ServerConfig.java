package com.cloud.frame.auth.user.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @program: top-parent
 * @description: OAuth2 认证配置
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 03:12
 **/

//@Configuration
//@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {


    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;


    public OAuth2ServerConfig() {
        super();
    }

    /** 
     * @description: Configure the non-security features of the Authorization Server endpoints,
     * like token store, token customizations, server approvals and grant types.
     * @param:
     * @return:
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
        security.realm("server-resources")//code授权添加
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")//allow check token
                .allowFormAuthenticationForClients();

    }

    /** 
     * @description:  Configure the security of the Authorization Server,
     * which means in practical terms the /oauth/token endpoint.
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
        clients.inMemory()
                .withClient("demoApp")
                .secret("demoAppSecret")
                .redirectUris("http://baidu.com")
                .authorizedGrantTypes("authorization_code","client_credentials", "password", "refresh_token")
                .scopes("all")
                .resourceIds("server-resource")
                .accessTokenValiditySeconds(1200)
                .refreshTokenValiditySeconds(50000);
    }

    /** 
     * @description: Configure the security of the Authorization Server,
     * which means in practical terms the /oauth/token endpoint.
     * void
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
    }


    /** 
     * @description: 解决 There is no PasswordEncoder mapped for the id "null"
     * @param:
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/22/18 
    */ 
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
