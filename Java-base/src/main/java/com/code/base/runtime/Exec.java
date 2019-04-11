package com.code.base.runtime;

import java.io.InputStream;

public class Exec {

    public static void main(String args[]){

        run("pwd");
        run("ls -l");
    }


    public static void run(String command){
        try{
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();

           /* byte[] read = new byte[10000];

            int len = inputStream.read(read);*/

            byte[] read = new byte[100];
            int len = 0;
            while ( (len=inputStream.read(read,0,5)) != -1){
                System.out.print(new String(read,0,len));
            }




        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
