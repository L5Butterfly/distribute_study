package com.oxygen.example;

/**
 * 启动发布服务进行监听
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:56
 **/
public class Bootstrap {

    public static void main(String[] args) {
        //SPRING BOOT
        IOrderService orderService=new OrderServiceImpl();
        RpcProxyServer rpcProxyServer=new RpcProxyServer();
        rpcProxyServer.publisher(orderService,8080);
    }
}
