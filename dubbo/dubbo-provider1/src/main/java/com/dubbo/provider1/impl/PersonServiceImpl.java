package com.dubbo.provider1.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.common.pojo.Person;
import com.common.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@Service(weight = 5)
public class PersonServiceImpl implements PersonService {


    @Override
    public Person findPerson(String name) {

        log.debug("findPerson　{}",name);
        Person person = new Person();
        person.setAge(18);
        person.setName(name+" provider-1");


        return person;
    }
}
