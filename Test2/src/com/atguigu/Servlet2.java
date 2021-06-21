package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 查看
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数："+username);
        //查看Servlet1是否有盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("检查Servlet1是否有盖章："+key1);
        //处理自身业务
        System.out.println("Servlet2处理自己的业务");
    }
}
