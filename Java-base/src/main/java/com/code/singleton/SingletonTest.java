package com.code.singleton;

import com.code.serialized.JdkSerialize;

public class SingletonTest {

    public static void main(String args[]){

       /* for(int i = 0; i< 10; i++){

            new Thread(){
                @Override
                public void run() {
                    test1();
                }
            }.start();
        }*/

       try{

           System.out.println();
       }
       catch(Exception ex){

       }

        test2();

    }


    public static  void test1(){


        System.out.println("Singleton1..........");
        for(int i = 0; i< 5; i++){

            System.out.println(Singleton1.getSingleton());
        }

        System.out.println("Singleton2..........");
        for(int i = 0; i< 5; i++){

            System.out.println(Singleton2.getSingleton());
        }

        System.out.println("Singleton3..........");
        for(int i = 0; i< 5; i++){

            System.out.println(Singleton3.getSingleton());
        }

        System.out.println("Singleton4..........");
        for(int i = 0; i< 5; i++){

            System.out.println(Singleton4.getSingleton());
        }
        System.out.println("Singleton5..........");
        for(int i = 0; i< 5; i++){

            System.out.println(Singleton5.getSingleton());
        }


    }

    public static void test2(){

        JdkSerialize serialize = new JdkSerialize();
        byte[] body = null;

        Singleton1 singleton1 =  Singleton1.getSingleton();
        body = serialize.serialize(singleton1);
        Singleton1 singleton1_1 = serialize.deserialize(body,null);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton1_1.hashCode());
        System.out.println();

        Singleton2 singleton2 =  Singleton2.getSingleton();
        body = serialize.serialize(singleton2);
        Singleton2 singleton2_1 = serialize.deserialize(body,null);
        System.out.println(singleton2.hashCode());
        System.out.println(singleton2_1.hashCode());
        System.out.println();

        Singleton3 singleton3 =  Singleton3.getSingleton();
        body = serialize.serialize(singleton3);
        Singleton3 singleton3_1 = serialize.deserialize(body,null);
        System.out.println(singleton3.hashCode());
        System.out.println(singleton3_1.hashCode());
        System.out.println();

        Singleton4 singleton4 =  Singleton4.getSingleton();
        body = serialize.serialize(singleton4);
        Singleton4 singleton4_1 = serialize.deserialize(body,null);
        System.out.println(singleton4.hashCode());
        System.out.println(singleton4_1.hashCode());
        System.out.println();

        Singleton5 singleton5 =  Singleton5.getSingleton();
        body = serialize.serialize(singleton5);
        Singleton5 singleton5_1 = serialize.deserialize(body,null);
        System.out.println(singleton5.hashCode());
        System.out.println(singleton5_1.hashCode());
        System.out.println();








    }
}
