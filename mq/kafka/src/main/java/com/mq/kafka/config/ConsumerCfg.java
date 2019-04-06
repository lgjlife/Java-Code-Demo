package com.mq.kafka.config;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsumerCfg {

    private String groupId = "default_group";


}
