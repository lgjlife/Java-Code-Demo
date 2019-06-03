package com.fastdfs.fastdfs.service;


import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Set;

@Slf4j
@Service
public class FastdfsService {

    String curGroup;
    String curPath;

    StorePath curStorePath;


    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;


    public String upload() throws FileNotFoundException {
        File file = new File("img/timg.jpeg");

        log.info(file.getAbsolutePath());
        // 上传并且生成缩略图
        log.info("start upload");
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpeg", null);
        log.info("finish upload");

        curStorePath = storePath;
        // 带分组的路径
        log.info(storePath.getFullPath());
        // 不带分组的路径
        log.info(storePath.getPath());

        return storePath.getFullPath();

    }

    public void delete(String path){

        String groupName = "group1";
        path = "M00/00/00/fwAAAVz1X0KAEmnfAAIIC7qVPOg26.jpeg";

       // storageClient.deleteFile(groupName+path);
        try{

            storageClient.deleteFile(curStorePath.getFullPath());
            log.info("文件删除成功!");
        }
        catch(Exception ex){
            log.info("文件删除失败!");
            log.error(ex.getMessage());

        }




    }

    public Set<MetaData> metadata(){
        String groupName = "group1";
        String path = "M00/00/00/fwAAAVz1X0KAEmnfAAIIC7qVPOg26.jpeg";

        log.info("getMetadata:{}",curStorePath);
        return storageClient.getMetadata(curStorePath.getGroup(),curStorePath.getPath());
    }

    public void downloadFile(){
        String groupName = "group1";
        String path = "M00/00/00/fwAAAVz1X0KAEmnfAAIIC7qVPOg26.jpeg";

        log.info("start downloadFile");
        log.info("downloadFile:{}",curStorePath);
        storageClient.downloadFile(curStorePath.getGroup(),curStorePath.getPath(),new DownloadCallback(){
            @Override
            public Object recv(InputStream inputStream) throws IOException {
                log.info("end downloadFile");
                log.info("down success");
                inputStream.close();

                inputStream.read();
                return null;
            }
        });


    }


}
