package com.boot.properties.config;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Data
@ToString
@ConfigurationProperties(prefix = "all")
public class AllConfigurationProperties {


    private  String name;
    private  OtherProperties other;

    private  String[] server;

    private List list;


    private Map map;

    private Map<String, ModuleConfig> modules = new LinkedHashMap();

    private List<ModuleConfig> modulesList;

}
