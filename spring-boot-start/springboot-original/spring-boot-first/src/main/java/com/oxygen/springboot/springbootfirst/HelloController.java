package com.oxygen.springboot.springbootfirst;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * HelloController
 * @author oxygen
 * @date 2020/6/16
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Mic";
    }

}
