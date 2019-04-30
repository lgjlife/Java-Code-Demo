package com.code.base.util.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {

    private volatile Integer num = 12;

    public static void main(String args[]){

        Unsafe unsafe = getUnsafe();
        try{


            String feildName = "num";
            long offset =   unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField(feildName));
            //int baseOffset =  unsafe.arrayBaseOffset(UnsafeDemo.class);

            System.out.println("baseOffset = "  + " feild num offset = " + offset);

            UnsafeDemo unsafeDemo =  new UnsafeDemo();

            for(int i = 0; i< 100; i++){
            /*    unsafe.getInt(unsafeDemo, i)
                System.out.println(unsafe.getInt(unsafeDemo, i));*/
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe)f.get(null);
        } catch (Exception e) {
            /* ... */
        }
        return  null;
    }

}


