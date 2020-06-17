package com.oxygen.example;

/**
 * TestServiceImpl
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:36
 **/
@GpRemoteService
public class TestServiceImpl implements ITestService{
    
    @Override
    public String sayHello() {
        return "RETURN SAYHELLO";
    }
}
