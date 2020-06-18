package com.oxygen.example;

/**
 * 服务实现
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 8:55
 **/
public class OrderServiceImpl implements IOrderService{

    @Override
    public String queryOrderList() {
        return "EXECUTE QUERYORDERLIST METHOD";
    }

    @Override
    public String orderById(String id) {
        return "EXECUTE ORDER_BY_ID METHOD";
    }
}
