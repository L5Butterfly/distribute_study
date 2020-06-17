package com.oxygen.springboot.springbootfirst.seconddemo.current;

import com.oxygen.springboot.springbootfirst.seconddemo.other.OtherConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



/**
 * @Import注解导入其他配置
 * @author oxygen
 * @date 2020/6/16
 **/
@Import(OtherConfig.class)
@Configuration
public class SpringConfig {

    @Bean
    public DefaultBean defaultBean(){
        return new DefaultBean();
    }
}
