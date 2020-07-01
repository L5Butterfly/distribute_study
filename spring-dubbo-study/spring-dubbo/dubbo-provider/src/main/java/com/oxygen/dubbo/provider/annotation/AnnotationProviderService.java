package com.oxygen.dubbo.provider.annotation;


/**
 * 注解方式配置服务
 * @author oxygen
 * @date 2020/6/28
 **/
public interface AnnotationProviderService {

    /**
     * SayHelloAnnotation
     * @param word
     * @return
     */
    String SayHelloAnnotation(String word);
}
