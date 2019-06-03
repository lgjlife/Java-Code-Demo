package com.fastdfs.fastdfs.controller;


import com.fastdfs.fastdfs.service.FastdfsService;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/fastdfs")
public class FastdfsController {

    @Autowired
    FastdfsService fastdfsService;

    @RequestMapping("/upload")
    public String upload(){

        String  path = null;
        try{
            path = fastdfsService.upload();
        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }
        return path;

    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("url") String url){

        log.info("delete url = {}",url);
        fastdfsService.delete(url);
    }
    @RequestMapping("/downloadFile")
    public void downloadFile(){
        fastdfsService.downloadFile();
    }

    @RequestMapping("/metadata")
    public Set<MetaData> metadata(){
        return fastdfsService.metadata();
    }
}
