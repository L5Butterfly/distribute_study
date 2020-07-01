package com.oxygen.dubbo;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.oxygen.dubbo.provider.service.ProviderService;

/**
 * AppApiMain
 * @author oxygen
 * @date 2020/6/28
 **/
public class AppApiMain {

    public static void main(String[] args) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
        application.setOwner("oxygen");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        // 引用远程服务
        ReferenceConfig<ProviderService> reference = new ReferenceConfig<ProviderService>();
        reference.setApplication(application);
        // 多个注册中心可以用setRegistries()
        reference.setRegistry(registry);
        reference.setInterface(ProviderService.class);
        reference.setVersion("1.0.0");
        reference.setGroup("oxygen");

        // 和本地bean一样使用xxxService
        // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        ProviderService providerService = reference.get();
        String s = providerService.SayHello("hello dubbo! I am oxygen!");
        System.out.println(s);
    }
}
