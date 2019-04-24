package com.dubbo.provider2.impl;

import com.common.pojo.Person;
import com.common.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@Service
public class PersonServiceImpl implements PersonService {


    @Override
    public Person findPerson(String name) {

        log.debug("findPerson　{}",name);
        Person person = new Person();
        person.setAge(18);
        person.setName(name+" provider-2");


        return person;
    }
}
