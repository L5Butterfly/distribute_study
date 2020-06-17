package com.oxygen.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * 使用多线程的方式处理---网络IO请求阻塞的问题
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:26
 **/
public class ProcessorHandler implements Runnable{

    /**
     * socket 网络请求
     */
    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;
        try {
            // 获取输入流，网络io中管道获取请求
            inputStream=new ObjectInputStream(socket.getInputStream());
            // 反序列化
            RpcRequest request=(RpcRequest)inputStream.readObject();
            // 根据请求服务信息，路由到对用的服务
            Mediator mediator=Mediator.getInstance();
            Object rs=mediator.processor(request);
            System.out.println("服务端的执行结果："+rs);
            // 网络IO写获取，请求响应
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rs);
            // 刷新缓存
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
