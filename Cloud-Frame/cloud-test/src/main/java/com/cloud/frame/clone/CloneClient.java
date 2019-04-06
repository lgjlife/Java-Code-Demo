package com.cloud.frame.clone;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-30 16:14
 **/
public class CloneClient {

    public static void main(String[] args) {


        Integer[] d1 = {1,1,1,1};
        Integer[] d2 = {2,2,2,2};
        MyObject[] o1 = {new MyObject("1111")};
        MyObject[] o2 = {new MyObject("2222")};

        People p1 = new People("1111",d1,o1);

        People p2 = (People)p1.clone();

        p1.setName("2222");
        d1[0] = 123;
        o1[0] = new MyObject("2222");
     //   p1.setData(d2);
    //    p1.setObj(o2);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2 );
    }
}
