package com.oxygen.starter.autoconfiguration;


import com.oxygen.starter.format.FormatProcessor;
import com.oxygen.starter.format.JsonFormatProcessor;
import com.oxygen.starter.format.StringFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * Configuration 配置类，注册Bean加载到Ioc容器
 * @author oxygen
 * @date 2020/6/16
 **/
@Configuration
public class FormatAutoConfiguration {

    /**
     * @Primary 优先加载，多数据源的情况下使用
     * @ConditionalOnMissingClass 没有某个包的时候加载
     * metadata-auto....
     * @return
     */
    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    @Bean
    @Primary
    public FormatProcessor stringFormat(){
        return new StringFormatProcessor();
    }


    /**
     * @ConditionalOnClass 添加加载，有这个包的情况下加载，和上面的情况是互斥的
     * @return
     */
    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    @Bean
    public FormatProcessor jsonFormat(){
        return new JsonFormatProcessor();
    }

}
