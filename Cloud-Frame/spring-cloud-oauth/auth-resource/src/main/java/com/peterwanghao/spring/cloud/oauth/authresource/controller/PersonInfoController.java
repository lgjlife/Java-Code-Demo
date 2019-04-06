package com.peterwanghao.spring.cloud.oauth.authresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.peterwanghao.spring.cloud.oauth.authresource.model.Person;

import java.util.Date;

/**   
 * @ClassName:  PersonInfoController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午2:43:05
 * @version V1.0
 * 
 */
@RestController
public class PersonInfoController {

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody Person personInfo() {
        return new Person("peter", "Beijing", "China", 29, "Male");
    }

    @GetMapping("/person1")
   // @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody Person personInfo1() {
        return new Person("peter", "Beijing", "China", 29, "Male");
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test ............." + new Date().toString();
    }

}
