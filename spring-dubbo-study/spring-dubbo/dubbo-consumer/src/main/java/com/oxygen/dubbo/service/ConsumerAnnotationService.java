package com.oxygen.dubbo.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.oxygen.dubbo.provider.annotation.AnnotationProviderService;
import org.springframework.stereotype.Component;

/**
 * ConsumerAnnotationService
 * @author oxygen
 * @date 2020/6/28
 **/
@Component
public class ConsumerAnnotationService {


    /**
     * dubbo 消费者端的服务注入调用
     */
    //@Reference
    @Reference(version = "1.0.0",check = true)
    private AnnotationProviderService annotationProviderService;


    /**
     * 调用消费者端
     * @param name
     * @return
     */
    public String doSayHello(String name) {
        return annotationProviderService.SayHelloAnnotation(name);
    }
}
