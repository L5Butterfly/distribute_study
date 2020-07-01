package com.oxygen.example;

import java.io.Serializable;

/**
 * RpcRequest 服务请求信息的封装
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:57
 **/
public class RpcRequest implements Serializable{

    private String className;
    private String methodName;
    private Object[] args;
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}