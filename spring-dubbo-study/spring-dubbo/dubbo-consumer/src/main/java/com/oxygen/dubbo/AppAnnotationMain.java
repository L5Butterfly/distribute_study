package com.oxygen.dubbo;


import com.oxygen.dubbo.configuation.ConsumerConfiguration;
import com.oxygen.dubbo.service.ConsumerAnnotationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * AppAnnotationMain
 * @author oxygen
 * @date 2020/6/28
 **/
public class AppAnnotationMain {


    /**
     * 注解的编程
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        // 启动
        context.start();
        ConsumerAnnotationService consumerAnnotationService3 =(ConsumerAnnotationService) context.getBean("consumerAnnotationService");
        ConsumerAnnotationService consumerAnnotationService = context.getBean(ConsumerAnnotationService.class);
        // 调用方法
        String hello = consumerAnnotationService.doSayHello("annotation");
        // 输出结果
        System.out.println("result: " + hello);

    }
}
