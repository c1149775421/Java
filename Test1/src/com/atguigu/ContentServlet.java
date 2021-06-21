package com.atguigu;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("context-param参数的username值是："+username);
        System.out.println("context-param参数的password值是："+password);
        //2.获取当前工程路径 格式：/工程路径
        System.out.println("当前工程路径是："+context.getContextPath());
        //3.获取工程部署后在服务器上的绝对路径
        //斜杠被服务器解析地址为：http://ip:port/工程名/
        System.out.println("工程部署的绝对路径是："+context.getRealPath("/"));
    }
}
