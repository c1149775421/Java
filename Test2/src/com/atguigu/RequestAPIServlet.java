package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println("URI => "+req.getRequestURI());
        //获取请求的统一资源定位符(绝对路径)
        System.out.println("URL => "+req.getRequestURL());
        //获取客户端的IP地址
        System.out.println("客户端IP地址 => "+req.getRemoteHost());
        //获取请求头
        System.out.println("请求头 => "+req.getHeader("User-Agent"));
        //获取请求的方式
        System.out.println("请求的方法 => "+req.getMethod());
    }
}
