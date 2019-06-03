package com.fastdfs.fastdfs.controller;

import com.fastdfs.fastdfs.service.DefaultTrackerClientService;
import com.github.tobato.fastdfs.domain.fdfs.GroupState;
import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fastdfs/tracker")
public class TrackerClientController {

    @Autowired
    DefaultTrackerClientService trackerClientService;

    @RequestMapping("/storage")
    public StorageNode getStoreStorage(){
        return trackerClientService.getStoreStorage();

    }

    @RequestMapping("/groups")
    public List<GroupState> listGroups(){
        return trackerClientService.listGroups();

    }




}
