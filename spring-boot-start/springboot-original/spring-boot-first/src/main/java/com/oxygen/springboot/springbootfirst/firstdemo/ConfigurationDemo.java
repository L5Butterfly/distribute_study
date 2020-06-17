package com.oxygen.springboot.springbootfirst.firstdemo;
import org.springframework.context.annotation.Configuration;


/**
 * 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
 * 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 * 并用于构建bean定义，初始化Spring容器。
 * @author oxygen
 * @date 2020/6/16
 **/
@Configuration
public class ConfigurationDemo {


}
