package com.elasticsearch.controller;


import com.elasticsearch.dao.Admin;
import com.elasticsearch.service.ElaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/ela")
public class ElaController {

    @Autowired
    private  ElaService elaService;

    @RequestMapping("/add")
    public String add(){
        log.info("/ela/add");
        String documentId = elaService.add();

        return documentId;


    }

    @RequestMapping("/update")
    public void update(){
        log.info("/ela/update");


    }

    @RequestMapping("/delete")
    public void delete(){
        log.info("/ela/delete");


    }


    @RequestMapping("/query/{query}")
    public List<Admin> query(@PathVariable("query") String query){
        log.info("/ela/query");
        log.info("查询的字符串:" + query);
        return elaService.query(query);


    }


}
