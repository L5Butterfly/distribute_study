package com.oxygen.example.springbootstarterdemo;

import com.oxygen.starter.HelloFormatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * http://127.0.0.1:8080/format
 * FormatController
 * @author oxygen
 * @date 2020/6/16
 **/
@RestController
public class FormatController {

    @Autowired
    HelloFormatTemplate helloFormatTemplate;

    @GetMapping("/format")
    public String format(){
        User user=new User();
        user.setAge(18);
        user.setName("Mic");
        return helloFormatTemplate.doFormat(user);
    }
}
