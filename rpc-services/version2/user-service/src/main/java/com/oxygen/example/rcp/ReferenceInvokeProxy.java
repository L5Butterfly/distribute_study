package com.oxygen.example.rcp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * ReferenceInvokeProxy
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:55
 **/
@Component
public class ReferenceInvokeProxy implements BeanPostProcessor{

    /**
     * 代理对象，代理对象的invoke方法具体的代理实现
     */
    @Resource
    RemoteInvocationHandler invocationHandler;


    /**
     * postProcessBeforeInitialization 实例化前处理，IOC容器实例化前处理
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //获取Controller内部所有的二方包接口的调用服务进行查询注入
        Field[] fields=bean.getClass().getDeclaredFields();
        for(Field field : fields){
            // 含有这个的服务调用通过动态代理去远程调用
            if(field.isAnnotationPresent(GpReference.class)){
                field.setAccessible(true);
                //针对这个加了GpReference注解的字段，设置为一个代理的值
                Object proxy= Proxy.newProxyInstance(field.getType().getClassLoader(),new Class<?>[]{field.getType()},invocationHandler);
                try {
                    //相当于针对加了GpReference的注解，设置了一个代理，这个代理的实现是invocationHandler
                    // DI注入，注入的代理对象，代理对象去网络IO调用远程服务
                    field.set(bean,proxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
