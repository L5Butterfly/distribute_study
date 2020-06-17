package com.oxygen.starter;

import com.oxygen.starter.autoconfiguration.HelloProperties;
import com.oxygen.starter.format.FormatProcessor;


/**
 * HelloFormatTemplate 更加不同的环境选择不同的对象序列化方式处理
 * @author oxygen
 * @date 2020/6/16
 **/
public class HelloFormatTemplate {

    /**
     * 对象格式化方式
     */
    private FormatProcessor formatProcessor;


    /**
     * 配置文件
     */
    private HelloProperties helloProperties;


    /**
     * 构造方法注入
     * @param helloProperties
     * @param formatProcessor
     */
    public HelloFormatTemplate(HelloProperties helloProperties,FormatProcessor formatProcessor) {
        this.helloProperties=helloProperties;
        this.formatProcessor = formatProcessor;
    }


    /**
     * HelloFormatTemplate.doFormat() 调用方法对对象进行处理
     * @param obj
     * @param <T>
     * @return
     */
    public <T> String doFormat(T obj){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("begin:Execute format").append("<br/>");
        stringBuilder.append("HelloProperties:").append(formatProcessor.format(helloProperties.getInfo())).append("<br/>");
        stringBuilder.append("Obj format result:").append(formatProcessor.format(obj)).append("<br/>");
        return stringBuilder.toString();

    }
}
