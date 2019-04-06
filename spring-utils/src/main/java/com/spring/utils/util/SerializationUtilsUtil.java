package com.spring.utils.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;

/**
 *功能描述 
 * @author lgj
 * @Description   JDK序列化工具
 * @date 3/25/19
*/
public class SerializationUtilsUtil {

    public static void main(String args[]){

        Ser ser = new Ser("aaa",122);
        byte[] body = SerializationUtils.serialize(ser);

        Ser ser1 = (Ser)SerializationUtils.deserialize(body);
        System.out.println(ser1);


    }
}


@Data
@AllArgsConstructor
class Ser  implements Serializable {
    private  String name ;
    transient  private  int age;

}
