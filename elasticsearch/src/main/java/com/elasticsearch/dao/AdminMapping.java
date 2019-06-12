package com.elasticsearch.dao;

import org.springframework.data.elasticsearch.annotations.Mapping;

@Mapping
public class AdminMapping {

    private String id;
    private String name;
    private String age;
    private String height;
    private String desc;


}
