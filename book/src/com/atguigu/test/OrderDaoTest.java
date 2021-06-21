package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import javax.management.Query;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    @Test
    public void saveOrder(){
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567891",new Date(),new BigDecimal(100),0,1));
    }

    @Test
    public void changeOrderStatus(){
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.changeOrderStatus("16192657818267",1);
    }

    @Test
    public void queryOrders(){
        OrderDao orderDao = new OrderDaoImpl();
        ArrayList<Order> data = orderDao.queryOrders();
        data.forEach((Order order)->{
            System.out.println(order);
        });
    }
    @Test
    public void test(){

    }

}