package com.oxygen.example;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Component Spring容器的注册标识的注解
 * GpRemoteService 自定义远程服务注册
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:11
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface GpRemoteService {

}
