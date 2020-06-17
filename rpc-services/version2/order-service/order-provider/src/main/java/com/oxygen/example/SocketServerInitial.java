package com.oxygen.example;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * onApplicationEvent 监听事件
 * spring 容器启动完成之后，会发布一个ContextRefreshedEvent= 进行监听RPC socket 端口
 * Created by oxygen
 * @author oxygen
 * @time 2020/6/18 2:33
 **/
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent>{

    /**
     * 多线程方式处理
     */
    private final ExecutorService executorService= Executors.newCachedThreadPool();


    /**
     * 容器启动成功后，注册事件进行监听，线程进行监听中
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //启动服务
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(8888);
            while(true){
                Socket socket=serverSocket.accept(); //监听客户端请求
                executorService.execute(new ProcessorHandler(socket));
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
