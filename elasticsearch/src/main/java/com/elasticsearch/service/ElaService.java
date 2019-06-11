package com.elasticsearch.service;


import com.elasticsearch.dao.Admin;
import com.elasticsearch.service.util.ElasticsearchHandler;
import com.elasticsearch.service.util.SearchConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


@Slf4j
@Service
public class ElaService {

    @Autowired
    private ElasticsearchHandler elasticsearchHandler;


    public String add(){
       Admin admin =  admin();
        String documentId =  elasticsearchHandler.create().createIndex(admin.getId()+"","admin_type",
                "admin_index",admin);
        return documentId;
    }


    public void update(){
        log.info("/ela/update");


    }


    public void delete(){
        log.info("/ela/delete");


    }



    public List<Admin>  query(String query){

        String[]  types = {"admin_type"};
        SearchConfig searchConfig =SearchConfig
                .builder()
                .queryString(query)
                .clazz(Admin.class)
                .highlightField("name")
                .types(types)
                .build();

        List<Admin> admins = elasticsearchHandler.query().search(searchConfig);
        return admins;



    }

    private Admin admin(){
        Admin admin = new Admin();
        admin.setId(Long.valueOf(new Random().nextInt(100)));
        admin.setName("总共过史蒂夫手动");
        admin.setAge((byte)18);
        admin.setDesc("散发的加快了发动机的该及科技概括了将");
        admin.setHeight(145);
        admin.setCreate(new Date());
        return admin;


    }



}
