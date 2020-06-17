package com.oxygen.example.rcp;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 客户端引用服务端口
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:55
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface GpReference {
}
