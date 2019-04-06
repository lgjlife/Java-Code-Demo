package com.cloud.frame.clone;

import java.util.Arrays;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-30 16:15
 **/
public class People implements Cloneable {

    String name;

    Integer[] data;

    MyObject[] obj;

    MyObject o;


    public People(String name, Integer[] data) {
        this.name = name;
        this.data = data;
    }

    public People(String name, Integer[] data, MyObject[] obj) {
        this.name = name;
        this.data = data;
        this.obj = obj;
    }

    public People(String name, Integer[] data, MyObject[] obj, MyObject o) {
        this.name = name;
        this.data = data;
        this.obj = obj;
        this.o = o;
    }

    @Override
    protected Object clone()   {

        People people = null;
        try {
            people = (People)super.clone();
        } catch (Exception ex) {

        } finally {

        }


        return people;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

    public void setObj(MyObject[] obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", data=" + Arrays.toString(data) +
                ", obj=" + Arrays.toString(obj) +
                ", o=" + o +
                '}';
    }
}


class MyObject{

    String name;

    public MyObject(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                '}';
    }
}