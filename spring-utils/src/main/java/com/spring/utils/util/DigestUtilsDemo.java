package com.spring.utils.util;

import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 *功能描述
 * @author lgj
 * @Description  MD5 摘要计算，可用于文件摘要计算
 * @date 3/26/19
*/
public class DigestUtilsDemo {

    public static void main(String args[]){

        try{
            File file = new File("file/file.txt");
            long lastModified  = file.lastModified();
            System.out.println("lastModified = " + new Date(lastModified));
            FileInputStream fis = new FileInputStream(file);

            String md5 = DigestUtils.md5DigestAsHex(fis);
            System.out.println("md5 = " + md5);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }




    }
}
