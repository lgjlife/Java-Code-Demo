package com.elasticsearch.dao;


import lombok.Data;

@Data
public class Location {

    private String city;
    private Integer code;

    public Location() {
    }

    public Location(String city, Integer code) {
        this.city = city;
        this.code = code;
    }
}
