package com.oxygen.springboot.springbootfirst.seconddemo;

import com.oxygen.springboot.springbootfirst.seconddemo.current.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * SecondMain
 * @author oxygen
 * @date 2020/6/16
 **/
public class SecondMain {

    public static void main(String[] args) {
        //@Import(OtherConfig.class) 配置类导入其他的配置类加载到Ioc容器
        AnnotationConfigApplicationContext applicationContext=new
                AnnotationConfigApplicationContext(SpringConfig.class);

        String[] defNames=applicationContext.getBeanDefinitionNames();
        for(int i=0;i<defNames.length;i++){
            System.out.println(defNames[i]);
        }
    }
}
