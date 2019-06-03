package com.fastdfs.fastdfs.service;

import com.github.tobato.fastdfs.domain.fdfs.GroupState;
import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import com.github.tobato.fastdfs.service.DefaultTrackerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DefaultTrackerClientService {

    @Autowired
    DefaultTrackerClient trackerClient;

    public StorageNode getStoreStorage(){
        StorageNode storageNode = trackerClient.getStoreStorage();
        log.info("StorageNode = {}" ,storageNode);
        return storageNode;

    }

    public List<GroupState> listGroups() {
        return  trackerClient.listGroups();
    }


}
