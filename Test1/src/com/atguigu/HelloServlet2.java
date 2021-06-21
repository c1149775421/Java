package com.atguigu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    public void doGet2(){
        System.out.println("HelloServlet2 doGet method");
        System.out.println("ok\n");
    }
    public void doPost2(){
        System.out.println("HelloServlet2 doPost method");
        System.out.println("ok\n");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//调用init的父类并传入config（不调用会发生空指针异常的问题）
        System.out.println("重写init初始化方法，做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        ServletConfig servletConfig = getServletConfig();//只能获取自己的param-init对应的初始化参数
        System.out.println(servletConfig);
        System.out.println("初始化参数username的值是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+servletConfig.getInitParameter("url"));
        doGet2();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doPost2();
    }
}
