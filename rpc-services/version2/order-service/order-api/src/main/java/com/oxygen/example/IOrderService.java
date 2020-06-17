package com.oxygen.example;


/**
 * IOrderService 订单服务接口，对我暴露的hsf接口
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:03
 **/
public interface IOrderService {


    /**
     * 查询订单列表
     * @return
     */
    String queryOrderList();


    /**
     *  根据订单查询
     * @param id
     * @return
     */
    String orderById(String id);
}
