package com.peterwanghao.spring.cloud.oauth.authresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**   
 * @ClassName:  Application
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午2:37:57
 * @version V1.0
 * 
 */
@EnableGlobalMethodSecurity(prePostEnabled = true) // Allow method annotations like @PreAuthorize
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
