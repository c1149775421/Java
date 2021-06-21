package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.ArrayList;

public interface OrderDao {
    //保存订单
    public int saveOrder(Order order);
    //查询全部订单
    public ArrayList<Order> queryOrders();
    //修改订单状态
    public int changeOrderStatus(String orderId, Integer status);
    //根据用户编号查询订单信息
    public Order queryOrdersByUserId(Order orderId);

}
