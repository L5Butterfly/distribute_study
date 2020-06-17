package com.oxygen.springboot.springbootfirst.fourdemo;

import com.oxygen.core.AppCore;
import com.oxygen.springboot.springbootfirst.thirddemo.EnableDemoMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * 
 * @author oxygen
 * @date 2020/6/16
 **/
@SpringBootApplication
public class FourMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca= SpringApplication.run(EnableDemoMain.class,args);

        System.out.println(ca.getBean(AppCore.class).study());
    }
}
