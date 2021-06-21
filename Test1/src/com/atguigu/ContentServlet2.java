package com.atguigu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();
        context.setAttribute("key1","value1");
        System.out.println("ContentServlet2中获取域数据key1的值是："+context.getAttribute("key1"));
//        System.out.println("username是："+context.getInitParameter("username")+
//                    "\n"+"password是："+context.getInitParameter("password"));
    }
}
