package com.oxygen.example;

/**
 * 对外暴露的服务
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:57
 **/
public interface IOrderService {

    String queryOrderList();

    String orderById(String id);
}
