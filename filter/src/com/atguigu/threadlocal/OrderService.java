package com.atguigu.threadlocal;

public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
//        System.out.println("当前线程["+name+"]中保存的数据是："+ThreadLocalTest.data.get(name));
        System.out.println("当前线程["+name+"]中保存的数据是："+ThreadLocalTest.threadLocal.get());
    }
}
