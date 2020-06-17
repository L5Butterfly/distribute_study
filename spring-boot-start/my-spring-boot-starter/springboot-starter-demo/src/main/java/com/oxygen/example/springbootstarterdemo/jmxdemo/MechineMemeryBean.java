package com.oxygen.example.springbootstarterdemo.jmxdemo;


/**
 * 把需要发布出去的指标信息,通过MB来进行发布
 * @author oxygen
 * @date 2020/6/16
 **/
public interface MechineMemeryBean {

    /**
     * 属性操作
     * @return
     */
    int getCpuCore();


    /**
     * 获取内存
     * @return
     */
    long getFreeMemory();


    /**
     * 关机
     */
    void shutdown();
}
