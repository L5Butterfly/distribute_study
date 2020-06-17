package com.oxygen.example.springbootstarterdemo.jmxdemo;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;


/**
 * JMXMain
 * @author oxygen
 * @date 2020/6/16
 **/
public class JMXMain {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer beanServer= ManagementFactory.getPlatformMBeanServer();
        ObjectName on=new ObjectName("Mechine:type=mechine");
        MechineMemeryBean mechineMBean=new Mechine();
        beanServer.registerMBean(mechineMBean,on);
        System.in.read();
    }
}
