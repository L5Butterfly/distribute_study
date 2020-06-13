package com.oxygen.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ServerSocket编程
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/13 18:03
 **/
public class ServerSocketDemo {

    /**
     * 创建固定大小的线程池
     * 即只要线程池没有满就会创建新的线程，并不会因为线程池的其他线程是空闲的就不创建新线程
     */
    static ExecutorService executorService= Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        try {
            //localhost: 8080
            serverSocket=new ServerSocket(8080);
            while(true) {
                //监听客户端连接(连接阻塞）
                Socket socket = serverSocket.accept();
                System.out.println(socket.getPort());
                //异步处理
                executorService.execute(new SocketThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
