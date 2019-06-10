package com.socket.socketclient;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

@Slf4j
public class SocketClient {

    private String bindAddress;
    private int port;
    private Socket socket;

    public SocketClient() {
    }

    public void connect(String bindAddress, int port) {
        this.bindAddress = bindAddress;
        this.port = port;

        try {
            log.info("SocketClient connect to [{}:{}]", bindAddress, port);
            socket = new Socket(bindAddress, port);

            socket.setSoTimeout(5000);
            socket.setKeepAlive(true);

            printSocketInfo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void send(String data) {


        log.info("socket 客户端发送信息:" + data);
        try {
            OutputStream os = socket.getOutputStream();
            //将输出流包装成打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write(data);
            pw.flush();
            //socket.shutdownOutput();
            printSocketInfo();

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void rec() {

        new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        InputStream is = socket.getInputStream();
                        int available = is.available();
                        log.info("available = " + available);
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader bufferedReader = new BufferedReader(isr);
                        String recData = null;
                        while ((recData = bufferedReader.readLine()) != null) {
                            log.info("接收到来自服务端的请求数据:"+recData);
                        }

                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                    }
                }
            }
        }.start();


    }

    public void printSocketInfo() {

        log.info("isClosed = " + socket.isClosed());
        log.info("isConnected = " + socket.isConnected());
        log.info("isBound = " + socket.isBound());
        log.info("isInputShutdown = " + socket.isInputShutdown());
        log.info("isOutputShutdown = " + socket.isOutputShutdown());
    }
}
