package com.elasticsearch.service.util;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class ElasticsearchHandler {


    @Autowired
    private  ElasticsearchCreateHandler createHandler;

    @Autowired
    private  ElasticsearchQueryHandler queryHandler;

    public ElasticsearchCreateHandler create(){
        return createHandler;
    }

    public ElasticsearchQueryHandler query(){
        return queryHandler;
    }





}
