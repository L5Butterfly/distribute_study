package com.oxygen.example.rcp;

import com.oxygen.example.IOrderService;
import com.oxygen.example.ITestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:55
 **/
@RestController
public class TestController {

    @GpReference
    private IOrderService orderService;

    @GpReference
    private ITestService testService;

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/get")
    public String get(){
        return testService.sayHello();
    }


}
