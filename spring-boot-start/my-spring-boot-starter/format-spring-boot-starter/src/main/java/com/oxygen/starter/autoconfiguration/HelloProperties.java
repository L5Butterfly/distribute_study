package com.oxygen.starter.autoconfiguration;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;


/**
 * 外部配置文件，xxx.properties文件加载属性
 * @ConfigurationProperties
 * @author oxygen
 * @date 2020/6/16
 **/
@ConfigurationProperties(prefix=HelloProperties.HELLO_FORMAT_PREFIX)
public class HelloProperties {

    /**
     * 配置文件的文件前缀信息
     */
    public static final String HELLO_FORMAT_PREFIX="oxygen.hello.format";

    /**
     * 加载配置文件properties文件的固定前缀的所有属性
     */
    private Map<String,Object> info;


    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
