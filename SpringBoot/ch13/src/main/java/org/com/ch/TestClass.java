package org.com.ch;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @program: swagger
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-07-04 01:00
 **/

@Component
@Configuration
@Import({org.com.zh.ZhClass.class})
public class TestClass {


}
