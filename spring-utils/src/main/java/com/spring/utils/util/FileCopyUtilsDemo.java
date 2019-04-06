package com.spring.utils.util;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileReader;

/**
 *功能描述 
 * @author lgj
 * @Description  文件复制类
 * @date 3/26/19
*/
public class FileCopyUtilsDemo {

    public static void main(String args[]){



        try{
            File source = new File("file/file.txt");
            File desc = new File("file/desc.txt");
           int result = FileCopyUtils.copy(source,desc);
            // 复制的字符数
            System.out.println("result = " + result)  ;

            //输入流复制到String
            FileReader reader = new FileReader(source);
            String re = FileCopyUtils.copyToString(reader);
            System.out.println("re = " + re);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
