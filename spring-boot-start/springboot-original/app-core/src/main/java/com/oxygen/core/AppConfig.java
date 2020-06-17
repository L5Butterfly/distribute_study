package com.oxygen.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * 【Spring注解驱动开发】使用@Scope注解设置组件的作用域
 * 配置注解为Bean
 * @author oxygen
 * @date 2020/6/16
 **/
@Configuration
public class AppConfig {


    /**
     * Spring容器中的组件默认是单例的，在Spring启动时就会实例化并初始化这些对象，将其放到Spring容器中，之后，每次获取对象时，
     * 直接从Spring容器中获取，而不再创建对象。如果每次从Spring容器中获取对象时，
     * 都要创建一个新的实例对象，该如何处理呢？此时就需要使用@Scope注解设置组件的作用域。
     * SCOPE_SINGLETON就是singleton，SCOPE_PROTOTYPE就是prototype。
     * @return
     */
    @Bean("appCore")
    @Scope("singleton")
    public AppCore appCore(){
        return new AppCore();
    }
}
