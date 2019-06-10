package com.socket.demo.impl.aserver;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SocketServer {

    private int port;
    private ServerSocket serverSocket;
    private Socket socket;

    public SocketServer() {
    }

    public void bind(int port) {
        this.port = port;

        try {
            log.info("SocketServer bind to port[{}]", port);
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
        } catch (Exception ex) {
            log.error(ex.getMessage());
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
            socket.shutdownOutput();
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
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader bufferedReader = new BufferedReader(isr);
                        String recData = null;
                        while ((recData = bufferedReader.readLine()) != null) {
                            log.info("接收到来自客户端的请求数据:");
                        }
                        socket.shutdownInput();


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
