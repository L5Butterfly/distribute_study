package com.oxygen.springboot.springbootfirst.thirddemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * EnableDemoMain
 * @author oxygen
 * @date 2020/6/16
 **/
@SpringBootApplication
@EnableDefineService
public class EnableDemoMain {

    public static void main(String[] args) {

        //获取配置上下文信息
        ConfigurableApplicationContext ca=SpringApplication.run(EnableDemoMain.class,args);

        // appContext上下文获取Bean实例
        System.out.println(ca.getBean(LoggerService.class));
        System.out.println(ca.getBean(CacheService.class));
    }


}
