package com.oxygen.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 服务启动类，通过注解式的方式加载服务
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:10
 **/
@Configuration
@ComponentScan("com.oxygen.example")
public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(Bootstrap.class);
    }
}
