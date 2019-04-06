package com.cloud.frame.oauth2.server.config;

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
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-10 17:16
 **/
@Configuration
//开启授权服务器
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    private  final static  String  RESOURCE_ID="user";

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

   // @Autowired
  //  JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    RedisTokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        System.out.println("AuthorizationServerConfig");
         clients.inMemory()
                 .withClient("client")
                 .authorizedGrantTypes("password","refresh_token","authorization_code","implicit")
                 .scopes("all") // 允许请求范围
                 .secret("secret")
                 .accessTokenValiditySeconds(600)
                 .redirectUris("http://localhost:6003");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        /*TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));*/



        endpoints.tokenStore(tokenStore)//(new InMemoryTokenStore())
               .accessTokenConverter(accessTokenConverter())
                // .tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("secret");
        return converter;
    }




    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    /**
     * tokenstore 定制化处理
     *
     * @return TokenStore
     * 1. 如果使用的 redis-cluster 模式请使用 PigRedisTokenStore
     * PigRedisTokenStore tokenStore = new PigRedisTokenStore();
     * tokenStore.setRedisTemplate(redisTemplate);
     */
   /* @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(jedisConnectionFactory);
        tokenStore.setPrefix("oauth2-");
        return tokenStore;
    }*/

    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    /*@Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(2);
            additionalInfo.put("license", "license");
            UserDetailsImpl user = (UserDetailsImpl) authentication.getUserAuthentication().getPrincipal();
            if (user != null) {
                additionalInfo.put("userId", user.getUserId());
            }
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        PigJwtAccessTokenConverter jwtAccessTokenConverter = new PigJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(CommonConstant.SIGN_KEY);
        return jwtAccessTokenConverter;
    }*/


    /*@Bean
    public  JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName();
    }*/

    /*@Bean
    DefaultStringRedisConnection getRedisConnectionFactory(){
        DefaultStringRedisConnection connection
                = new DefaultStringRedisConnection(redisConnectionFactory.getConnection());
        return   connection;
    }*/
}

