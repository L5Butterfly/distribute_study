package com.oxygen.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * BeanPostProcessor是Spring IOC容器给我们提供的一个扩展接口。接口声明如下：
 * 运行顺序
 *
 * ===Spring IOC容器实例化Bean===
 * ===调用BeanPostProcessor的postProcessBeforeInitialization方法===
 * ===调用bean实例的初始化方法===
 * ===调用BeanPostProcessor的postProcessAfterInitialization方法===
 *
 * https://www.jianshu.com/p/369a54201943
 *
 * Created by oxygen
 * @author oxygen
 * @time 2020/6/18 2:18
 **/
@Component
public class InitialMediator implements BeanPostProcessor{


    /**
     * bean初始化方法调用后被调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 根据注解判断是否是远程调用暴露的服务,是的需要加入到自己定义的容器中
        if(bean.getClass().isAnnotationPresent(GpRemoteService.class)){
            //加了服务发布标记的bean进行远程发布
            Method[] methods=bean.getClass().getDeclaredMethods();
            //将实现类的所有方法加入到容器中,服务的方法进行包装成统一额对象进行管理
            for(Method method : methods){
                String key=bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod=new BeanMethod();
                //设置服务类
                beanMethod.setBean(bean);
                //方法名称
                beanMethod.setMethod(method);
                Mediator.map.put(key,beanMethod);
            }
        }
        return bean;
    }


    /**
     * bean初始化方法调用前被调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

}
