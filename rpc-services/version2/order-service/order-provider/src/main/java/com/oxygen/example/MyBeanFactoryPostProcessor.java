package com.oxygen.example;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * BeanFactoryPostProcessor实例   ------个人学习扩展
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:21
 **/
@Component
public class MyBeanFactoryPostProcessor  implements BeanFactoryPostProcessor {


    /**
     * BeanFactoryPostProcessor简介
     * bean工厂的bean属性处理容器，说通俗一些就是可以管理我们的bean工厂内所有的beandefinition
     * （未实例化）数据，可以随心所欲的修改属性。
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
        int count = beanFactory.getBeanDefinitionCount();
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory中有"+count+" 个Bean");
        System.out.println(Arrays.asList(names));

    }
}
