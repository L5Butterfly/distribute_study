package com.oxygen.example;

import java.lang.reflect.Method;

/**
 * BeanMethod  包装服务的方法的信息
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:09
 **/
public class BeanMethod {

    /**
     * 服务实现对象
     */
    private Object bean;

    /**
     * 方法
     */
    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
