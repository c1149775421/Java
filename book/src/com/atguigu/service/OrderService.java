package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;

public interface OrderService {
    //生成订单
    public String createOrder(Cart cart, Integer userId);
    //查看所有订单
    public String showAllOrders();
    //发货
    public String sendOrder(String orderId);
    //查看订单详情
    public String showOrderDetail(Order orderId);
    //查看我的订单
    public String showMyOrders(Integer userId);
    //签收订单/确认收货
    public String receiverOrder(Order orderId);
}
