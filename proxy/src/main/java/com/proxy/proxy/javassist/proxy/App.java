package com.proxy.proxy.javassist.proxy;

public class App {

    public static void main(String args[]){
        JavassistProxy proxy = new JavassistProxy();

        try{
            ProxyServiceImpl proxyService = (ProxyServiceImpl)proxy.getProxy(ProxyServiceImpl.class);

            proxyService.run();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
