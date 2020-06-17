package com.oxygen.springboot.springbootfirst.thirddemo;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * EnableDefineService 自定义注解装配，加载Bean
 * @author oxygen
 * @date 2020/6/16
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CacheImportSelector.class,LoggerDefinitionRegistrar.class}) //
public @interface EnableDefineService {

    /**
     * 配置一些方法
     * @return
     */
    Class<?>[] exclude() default {};
}
