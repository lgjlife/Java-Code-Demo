package com.fastdfs.fastdfs.fastdfs;

import com.github.tobato.fastdfs.domain.conn.ConnectionManager;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DfsClient {

    @Autowired
    ConnectionManager connectionManager;

    @Autowired
    TrackerClient trackerClient;


    public DefaultFastFileStorageClient client(){

        DefaultFastFileStorageClient client =  new DefaultFastFileStorageClient();
        client.setConnectionManager(connectionManager);
        client.setTrackerClientService(trackerClient);
        return client;
    }
}
