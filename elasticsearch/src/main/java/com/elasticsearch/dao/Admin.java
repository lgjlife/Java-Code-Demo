package com.elasticsearch.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;


@Data
@Document(indexName = "admin_index",type = "admin_type")
public class Admin {

    private Long id;
    private String name;

    @Field(type = FieldType.Object)
    private byte age;

    @Field(type = FieldType.Integer)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer height;

    private String desc;

    @Field(type = FieldType.Object)
    private Location location;


    @Field(type = FieldType.Date, format = DateFormat.custom,pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd",timezone="GMT+8")
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
