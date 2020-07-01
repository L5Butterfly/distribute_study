package com.oxygen.dubbo;

import com.oxygen.dubbo.configuation.DubboConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * AppAnnotationMain
 * @author oxygen
 * @date 2020/6/28
 **/
public class AppAnnotationMain {

    public static void main(String[] args) throws IOException {
        // 通过注解的方式注入到Ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        context.start();
        System.in.read();
    }
}
