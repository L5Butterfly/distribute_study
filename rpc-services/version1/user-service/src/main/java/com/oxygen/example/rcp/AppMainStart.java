package com.oxygen.example.rcp;

import com.oxygen.example.IOrderService;

/**
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 9:13
 **/
public class AppMainStart
{
    public static void main( String[] args ){
        RpcProxyClient rpcProxyClient=new RpcProxyClient();
        IOrderService orderService=rpcProxyClient.clientProxy(IOrderService.class,"localhost",8080);

        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.orderById("Mic"));

    }
}
