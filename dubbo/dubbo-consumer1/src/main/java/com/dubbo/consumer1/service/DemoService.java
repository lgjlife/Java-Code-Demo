package com.dubbo.consumer1.service;


import com.common.pojo.Person;
import com.common.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoService {

    @Reference(loadbalance = "random")
    private PersonService personService;



    public Person findPersion(){

        Person person = personService.findPerson("libai");

        log.debug("person = {}",person);
        return  person;

    }
}
