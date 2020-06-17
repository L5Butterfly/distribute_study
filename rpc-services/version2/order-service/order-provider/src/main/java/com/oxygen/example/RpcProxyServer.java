package com.oxygen.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RPC网络IO请求处理
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:30
 **/
public class RpcProxyServer {

    /**
     * 使用线程池处理请求
     */
    private final ExecutorService executorService= Executors.newCachedThreadPool();


    /**
     * publisher
     * @param service
     * @param port
     */
    public void publisher(Object service,int port){
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
            //循环轮循监听处理请求
            while(true){
                //监听客户端请求, 阻塞请求
                Socket socket=serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭流
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
