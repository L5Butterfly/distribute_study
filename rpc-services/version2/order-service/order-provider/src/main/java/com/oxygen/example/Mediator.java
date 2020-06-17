package com.oxygen.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用来存储发布的服务的实例(服务调用的路由)
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:13
 **/
public class Mediator {

    /**
     * 用来存储发布的服务的实例-使用享元模式
     */
    public static Map<String ,BeanMethod> map=new ConcurrentHashMap<>();


    /**
     *  volatile 线程之间可见
     *  使用单例的形式, 双重检查锁实现单例，线程安全的单例
     */
    private volatile static Mediator instance;

    private Mediator(){};


    /**
     * 构建实例
     * @return
     */
    public static Mediator getInstance(){
        if(instance==null){
            synchronized (Mediator.class){
                if(instance==null){
                    instance=new Mediator();
                }
            }
        }
        return instance;
    }


    /**
     * 通过远程RPC调用获取的的请求信息进行服务方法的调用
     * @param request
     * @return
     */
    public Object processor(RpcRequest request){
        //key=接口名称+方法名称
        String key=request.getClassName()+"."+request.getMethodName();
        BeanMethod beanMethod=map.get(key);
        if(beanMethod==null){
            return null;
        }
        Object bean=beanMethod.getBean();
        Method method=beanMethod.getMethod();
        try {
            //反射调用
            return method.invoke(bean,request.getArgs());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
