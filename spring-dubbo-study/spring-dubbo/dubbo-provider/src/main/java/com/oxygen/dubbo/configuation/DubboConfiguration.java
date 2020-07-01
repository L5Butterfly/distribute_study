package com.oxygen.dubbo.configuation;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描对外暴露的接口服务API
 * @author oxygen
 * @date 2020/6/28
 **/
@Configuration
@EnableDubbo(scanBasePackages = "com.oxygen.dubbo.provider.annotation")
public class DubboConfiguration {


    /**
     * https://segmentfault.com/a/1190000019896723#item-7
     * 通过 @EnableDubbo 指定在com.sihai.dubbo.provider.service.annotation 下扫描所有标注有 @Service 的类
     * 通过 @Configuration 将 DubboConfiguration 中所有的 @Bean 通过 Java Config 的方式组装出来并注入给 Dubbo 服务，
     * 也就是标注有 @Service 的类。这其中就包括了：
     *
     * ProviderConfig：服务提供方配置
     * ApplicationConfig：应用配置
     * RegistryConfig：注册中心配置
     * ProtocolConfig：协议配置
     */


    /**
     * 服务提供者信息配置
     * @return
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(1000);
        return providerConfig;
    }

    /**
     * 分布式应用信息配置
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-annotation-provider");
        return applicationConfig;
    }


    /**
     * 注册中心信息配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("localhost");
        registryConfig.setPort(2181);
        return registryConfig;
    }


    /**
     * 使用协议配置，这里使用 dubbo
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
}
