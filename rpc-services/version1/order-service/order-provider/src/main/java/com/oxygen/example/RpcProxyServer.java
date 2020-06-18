package com.oxygen.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务注册
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:54
 **/
public class RpcProxyServer {

    private final ExecutorService executorService= Executors.newCachedThreadPool();

    public void publisher(Object service,int port){
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(port);
            while(true){
                Socket socket=serverSocket.accept(); //监听客户端请求
                executorService.execute(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
