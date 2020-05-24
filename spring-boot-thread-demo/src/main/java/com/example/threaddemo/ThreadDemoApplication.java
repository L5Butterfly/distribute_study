package com.example.threaddemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springbootthreaddemo.persistence")
@SpringBootApplication
public class ThreadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadDemoApplication.class, args);
    }

}
