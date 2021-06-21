package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.ArrayList;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    //查询全部订单
    @Override
    public ArrayList<Order> queryOrders(){
        String sql = "select `order_id`,`create_time`,`price`,`status`,`user_id` from t_order";
        return (ArrayList<Order>) queryForList(Order.class,sql);
    }

    //修改订单状态
    @Override
    public int changeOrderStatus(String orderId, Integer status){
        String sql = "update `t_order` set `status`=? where order_id=?";
        return update(sql,status,orderId);
    }

    //根据用户编号查询订单信息
    @Override
    public Order queryOrdersByUserId(Order orderId){
        return null;
    }

}
