package com.oxygen.springboot.springbootfirst.firstdemo;

//希望这个类被spring 托管

import org.springframework.stereotype.Service;




/**
 * DemoClass
 * @author oxygen
 * @date 2020/6/16
 **/
@Service
public class DemoClass {

    /**
     * xml 的 bean 配置
     * <bean name="" class="com.oxygen.springboot.springbootfirst.fristdemo.Democlass"/>
     * javaconfig
     * autoconfiguration  (简化我们bean的注入逻辑）
     */
    public void say(){
        System.out.println("Say: Hello Mic");
    }
}


