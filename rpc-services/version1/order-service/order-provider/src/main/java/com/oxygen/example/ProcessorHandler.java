package com.oxygen.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 多线程的方式处理网络IO请求
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:55
 **/
public class ProcessorHandler implements Runnable{

    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream=null;
        ObjectOutputStream outputStream=null;
        try {
            inputStream=new ObjectInputStream(socket.getInputStream());//?
            RpcRequest request=(RpcRequest)inputStream.readObject(); //反序列化
            Object rs=invoke(request);
            System.out.println("服务端的执行结果："+rs);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rs);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭流
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


    /**
     * 反射的方式调用
     * @param request
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object invoke(RpcRequest request) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //通过反射进行服务的调用
        Class clazz=Class.forName(request.getClassName());
        //找到目标方法
        Method method=clazz.getMethod(request.getMethodName(),request.getTypes());
        return method.invoke(service,request.getArgs());
    }
}
