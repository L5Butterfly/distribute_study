package com.oxygen.springboot.springbootfirst.seconddemo.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * OtherConfig
 * @author oxygen
 * @date 2020/6/16
 **/
@Configuration
public class OtherConfig {

    /**
     * otherBean
     * @return
     */
    @Bean
    public OtherBean otherBean(){
        return new OtherBean();
    }
}
