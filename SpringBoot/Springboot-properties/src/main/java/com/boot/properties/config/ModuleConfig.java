package com.boot.properties.config;

import lombok.Data;

@Data
public class ModuleConfig {
    private static final long serialVersionUID = 5508512956753757169L;
    private String name;
    private String version;
    private String owner;
}