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


    @Autowired
    private  ElasticsearchDeleteHandler deleteHandler;

    @Autowired
    private ElasticsearchMappingHandler mappingHandler;

    public ElasticsearchCreateHandler create(){
        return createHandler;
    }

    public ElasticsearchQueryHandler query(){
        return queryHandler;
    }


    public ElasticsearchDeleteHandler delete(){
        return deleteHandler;
    }

    public ElasticsearchMappingHandler mapping(){
        return mappingHandler;
    }



}
