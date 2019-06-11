package com.elasticsearch.dao;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "admin_index")
public class Admin {

    private Long id;
    private String name;
    private byte age;
    private Integer height;
    private String desc;

   // @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ",timezone="GMT+8")
    private Date create;

    /*public static void main(String args[]){

        ObjectMapper mapper = new ObjectMapper();
        Admin admin = admin();

        try{
            String json = mapper.writeValueAsString(admin);
            log.info("json = " + json);

            Admin admin1 = mapper.readValue(json,Admin.class);
            log.info("admin1 = " + admin1);
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
    }

    private static Admin admin(){
        Admin admin = new Admin();
        admin.setId(new Random().nextLong());
        admin.setName("总共过史蒂夫手动");
        admin.setAge((byte)18);
        admin.setDesc("散发的加快了发动机的该及科技概括了将");
        admin.setHeight(145);
        admin.setCreate(new Date());
        return admin;


    }*/


}
