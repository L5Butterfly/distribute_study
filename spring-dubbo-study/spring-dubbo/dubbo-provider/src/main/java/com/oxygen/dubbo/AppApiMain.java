package com.oxygen.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.oxygen.dubbo.provider.service.ProviderService;
import com.oxygen.dubbo.provider.service.impl.ProviderServiceImpl;

import java.io.IOException;


/**
 * AppApiMain
 * @author oxygen
 * @date 2020/6/28
 **/
public class AppApiMain {


    /**
     * Api方式启动
     * api的方式调用不需要其他的配置，只需要下面的代码即可。
     * 但是需要注意，官方建议：
     * Api方式用于测试用例使用，推荐xml的方式
     */
    public static void main( String[] args ) throws IOException {

        // 服务实现
        ProviderService providerService = new ProviderServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("provider");
        application.setOwner("oxygen");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");
        //registry.setUsername("oxygen");
        //registry.setPassword("oxygen");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        //protocol.setThreads(200);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<ProviderService> service = new ServiceConfig<ProviderService>();
        service.setApplication(application);
        // 多个注册中心可以用setRegistries()
        service.setRegistry(registry);
        // 多个协议可以用setProtocols()
        service.setProtocol(protocol);
        service.setInterface(ProviderService.class);
        service.setRef(providerService);
        service.setVersion("1.0.0");
        service.setGroup("oxygen");

        // 暴露及注册服务
        service.export();
        System.in.read();
    }
}
