package com.oxygen.example;

/**
 * 声明这个注解之后，自动发布服务-------发布到map容器中进行注册
 * Created by oxygen 
 * @author oxygen
 * @time 2020/6/18 2:26
 **/
@GpRemoteService
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
