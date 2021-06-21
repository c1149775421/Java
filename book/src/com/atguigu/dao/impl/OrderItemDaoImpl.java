package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    //保存订单项
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    //根据订单号查询订单明细
    @Override
    public OrderItem queryOrderItemByOrderId(OrderItem orderId){
        return null;
    }
}
