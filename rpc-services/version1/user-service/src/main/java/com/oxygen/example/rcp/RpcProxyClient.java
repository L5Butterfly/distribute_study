package com.oxygen.example.rcp;

import java.lang.reflect.Proxy;

/**
 * RpcProxyClient
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 9:14
 **/
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
