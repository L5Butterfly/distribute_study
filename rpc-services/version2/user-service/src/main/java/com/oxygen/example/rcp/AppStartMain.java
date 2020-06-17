package com.oxygen.example.rcp;

import com.oxygen.example.IOrderService;
import com.oxygen.example.ITestService;

/**
 * 应用启动
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:55
 **/
public class AppStartMain
{
    public static void main( String[] args ){
        RpcProxyClient rpcProxyClient=new RpcProxyClient();
        ITestService testService=rpcProxyClient.clientProxy(ITestService.class,"localhost",8080);
        System.out.println(testService.sayHello());
    }
}
