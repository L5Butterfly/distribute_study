package com.oxygen.example.springbootstarterdemo.jmxdemo;


/**
 * Mechine
 * @author oxygen
 * @date 2020/6/16
 **/
public class Mechine implements MechineMemeryBean{


    @Override
    public int getCpuCore() {

        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public long getFreeMemory() {

        return Runtime.getRuntime().freeMemory();

    }

    @Override
    public void shutdown() {
        System.exit(0);
    }
}
