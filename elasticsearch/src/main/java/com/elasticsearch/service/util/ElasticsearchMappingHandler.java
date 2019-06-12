package com.elasticsearch.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *功能描述
 * @author lgj
 * @Description  创建索引处理
 * @date 5/19/19
*/
@Component
public class ElasticsearchMappingHandler {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public Map getMapping(String indexName, String type){
       return elasticsearchTemplate.getMapping(indexName,type);
    }

    public boolean mapping(String indexName, String type, Object mapping){
        return elasticsearchTemplate.putMapping(indexName,type,mapping);
    }

    public <T> boolean putMapping(Class<T> clazz){
        return elasticsearchTemplate.putMapping(clazz);
    }



}
