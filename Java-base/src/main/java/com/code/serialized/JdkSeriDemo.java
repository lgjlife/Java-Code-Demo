package com.code.serialized;

import java.io.Serializable;

public class JdkSeriDemo {

    public static void main(String args[]){

        SerDemo demo =  new SerDemo(1,"LIBAI");
        JdkSerialize jdkSerialize = new JdkSerialize();
        byte[] body = jdkSerialize.serialize(demo);
        demo.setId(12);
        demo.setName("ssad");

        SerDemo demo1 = jdkSerialize.deserialize(body,null);

        demo.setId(1233);
        demo.setName("ssad333");

        System.out.println("demo1 ==  demo?" + (demo1 ==  demo));

        System.out.println("result = " + demo1);


    }


}
class SerDemo implements Serializable {

    private static final long serialVersionUID = 9527l;
    private Integer id;
    private String name;

    public SerDemo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
