package com.oxygen.springboot.springbootfirst.firstdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * ComponentScan 指定扫描的包路径
 * @author oxygen
 * @date 2020/6/16
 **/
@ComponentScan(basePackages = "com.oxygen.springboot.springbootfirst")
public class ConfigurationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationMain.class);

        //获取所有的ioc托管的Bean文件
        String[] defNames=applicationContext.getBeanDefinitionNames();
        for(int i=0;i<defNames.length;i++){
            System.out.println(defNames[i]);
        }

    }
}
