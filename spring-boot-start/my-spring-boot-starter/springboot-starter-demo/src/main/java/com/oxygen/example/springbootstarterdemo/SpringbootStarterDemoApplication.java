package com.oxygen.example.springbootstarterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;



/**
 * SpringbootStarterDemoApplication
 * @author oxygen
 * @date 2020/6/16
 **/
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
public class SpringbootStarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStarterDemoApplication.class, args);
    }

}
