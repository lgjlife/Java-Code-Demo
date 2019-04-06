package com.cloud.frame.security.oauth2.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-22 22:11
 **/
@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(OauthAuthorizationServerConfiguration.class);

    private static final String DEMO_RESOURCE_ID = "order";


    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

 //   @Autowired
  //  ClientDetailsService clientDetailsService;

    @Autowired
    CustomUserService userService;
    //数据库数据源
    @Autowired
    private DataSource dataSource;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证


        //1.认证相关参数放在数据库中,多个应用共享数据库
        if(false){
          //  clients.withClientDetails(clientDetailsService);
            log.info("配置jdbc方式....");
            clients.jdbc(dataSource);
        }

        //2.认证相关参数放在内存中，此种方法只适合单体应用

        if(true){
            log.info("配置内存方式....");
            clients.inMemory()
                    //必须的）用来标识客户的Id
                    .withClient("client_1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .redirectUris("http://localhost:8005/")
                    /*
                        authorization_code：授权码类型。
                        implicit：隐式授权类型。
                        password：资源所有者（即用户）密码类型。
                        client_credentials：客户端凭据（客户端ID以及Key）类型。
                        refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。
                     */
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    //用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
                    .scopes("select")
                    //此客户端可以使用的授权类型，默认为空。
                    .authorities("client")
                    //（需要值得信任的客户端）客户端安全码，如果有的话
                    .secret("123456")

                    .and().withClient("client_2")
                    .redirectUris("http://localhost:8005/")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456");
        }

    }

    /** 
     * @description: 配置使用
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 11/23/18 
    */ 
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userService)
                .authorizationCodeServices(authorizationCodeServices())
                .authenticationManager(this.authenticationManager)
                .tokenStore(tokenStore())
                .approvalStoreDisabled();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
    }



    @Bean
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }




}
