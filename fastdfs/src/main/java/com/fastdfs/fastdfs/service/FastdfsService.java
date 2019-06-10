package com.fastdfs.fastdfs.service;


import com.fastdfs.fastdfs.fastdfs.DfsClient;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class FastdfsService {

    String curGroup;
    String curPath;

    StorePath curStorePath;

   /* @Autowired
    DefaultFastFileStorageClient defaultFastFileStorageClient;*/


   @Autowired
    DfsClient dfsClient;
    @Autowired
    private DefaultFastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;


    public String upload() throws FileNotFoundException {
        File file = new File("img/timg.jpeg");

        Set<MetaData> metaDataSet = createMetaData();

        log.info(file.getAbsolutePath());
        // 上传并且生成缩略图
        log.info("start upload");
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpeg",
                metaDataSet);

        Set<MetaData> fetchMetaData = storageClient.getMetadata(storePath.getGroup(), storePath.getPath());

        log.info("MetaData = " +fetchMetaData);
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
        dfsClient.client().downloadFile(curStorePath.getGroup(),
                curStorePath.getPath(),
                new DownloadCallback(){
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

    private Set<MetaData> createMetaData() {
        Set<MetaData> metaDataSet = new HashSet<MetaData>();
        metaDataSet.add(new MetaData("Author", "tobato"));
        metaDataSet.add(new MetaData("CreateDate", "2016-01-05"));
        return metaDataSet;
    }


}
