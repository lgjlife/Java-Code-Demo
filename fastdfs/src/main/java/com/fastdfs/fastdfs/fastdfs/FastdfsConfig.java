package com.fastdfs.fastdfs.fastdfs;

import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastdfsConfig {

   // @Scope("prototype")
   // @Bean("asad")
    public DefaultFastFileStorageClient defaultFastFileStorageClient(){
        DefaultFastFileStorageClient defaultFastFileStorageClient = new DefaultFastFileStorageClient();
        return defaultFastFileStorageClient;
    }
}
