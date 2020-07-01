package com.oxygen.dubbo.provider.annotation.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oxygen.dubbo.provider.annotation.AnnotationProviderService;


/**
 * dubbo 服务注册
 * 注解方式实现类------@Service 用来配置 Dubbo 的服务提供方。
 * @author oxygen
 * @date 2020/6/28
 **/
@Service(version = "1.0.0",timeout = 5000,interfaceClass = AnnotationProviderService.class)
public class AnnotationProviderServiceImpl implements AnnotationProviderService {

    @Override
    public String SayHelloAnnotation(String word) {
        return word;
    }


}
