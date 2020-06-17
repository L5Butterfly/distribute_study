package com.oxygen.starter.autoconfiguration;


import com.oxygen.starter.HelloFormatTemplate;
import com.oxygen.starter.format.FormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



/**
 * HelloAutoConfiguration 注入HelloFormatTemplate 的 Bean实例
 * @EnableConfigurationProperties 配置文件定制化配置
 * @Import(FormatAutoConfiguration.class) 导入外部配置
 * @author oxygen
 * @date 2020/6/16
 **/
@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(HelloProperties.class)
@Configuration
public class HelloAutoConfiguration {


    /**
     *
     * @param helloProperties
     * @param formatProcessor
     * @return
     */
    @Bean
    public HelloFormatTemplate helloFormatTemplate(HelloProperties helloProperties, FormatProcessor formatProcessor){
        return new HelloFormatTemplate(helloProperties,formatProcessor);
    }
}
