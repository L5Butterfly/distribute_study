package com.oxygen.springboot.springbootfirst.thirddemo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;


/**
 * 通过ImportBeanDefinitionRegistrar 接口实现Bean加载Ioc容器
 * @author oxygen
 * @date 2020/6/16
 **/
public class LoggerDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     * 注冊bean
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Class beanClass=LoggerService.class;
        //构建一个Bean的包装实例，注册到Ioc容器
        RootBeanDefinition beanDefinition=new RootBeanDefinition(beanClass);
        //StringUtils.unCapitalize() 首字母小写转换方法
        String beanName=StringUtils.uncapitalize(beanClass.getSimpleName());
        beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
    }
}
