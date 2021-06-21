package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    //生成订单
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号确保唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

//        int i = 12 / 0;

        //遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);
            //更新销量和库存信息
            Book book = bookDao.queryBookById(cartItem.getId());//查询商品项id
            book.setSales( book.getSales() + cartItem.getCount() );//原销量加上购物车商品的数量
            book.setStock( book.getStock() - cartItem.getCount() );//原库存减去购物车商品的数量
            //如果库存小于0，则把库存改为0
            if(book.getStock() <= 0){
                book.setStock(0);
            }
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }

    //查看所有订单
    @Override
    public String showAllOrders(){
        return "";
    }

    //发货
    @Override
    public String sendOrder(String orderId){
        orderDao.changeOrderStatus(orderId,1);
        return orderId;
    }

    //查看订单详情
    @Override
    public String showOrderDetail(Order orderId){
        return "";
    }

    //查看我的订单
    @Override
    public String showMyOrders(Integer userId){
        return "";
    }

    //签收订单/确认收货
    @Override
    public String receiverOrder(Order orderId){
        return "";
    }
}
