package com.oxygen.example;

import java.io.Serializable;


/**
 * 后期优化： 单独抽出一个服务器，在项目里面设置起步依赖
 * RpcRequest RPC 网络传输的请求对象的封装,底层涉及到序列号的方式网传输的性能考虑
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:05
 **/
public class RpcRequest implements Serializable{

    private static final long serialVersionUID = -1585832895125364883L;

    /**
     * 服务接口类名称
     */
    private String className;

    /**
     * 接口方法
     */
    private String methodName;

    /**
     * 接口方法入参
     */
    private Object[] args;

    /**
     * 接口入参类型
     */
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
