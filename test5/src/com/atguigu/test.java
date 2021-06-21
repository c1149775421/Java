package com.atguigu;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class test extends BaseServlet {
    protected void http(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("1.协议："+req.getScheme()+"<br/>");
//        System.out.println("2.服务器ip："+req.getServerName()+"<br/>");
//        System.out.println("3.服务器端口："+req.getServerPort()+"<br/>");
//        System.out.println("4.获取工程路径："+req.getContextPath()+"<br/>");
//        System.out.println("5.获取请求方法："+req.getMethod()+"<br/>");
//        System.out.println("6.获取客户端ip地址："+req.getRemoteHost()+"<br/>");
//        System.out.println("7.获取会话的id编号："+req.getRequestedSessionId()+"<br/>");

        String str = "1.协议："+req.getScheme()+"<br/>";
        str += "2.服务器ip："+req.getServerName()+"<br/>";
        str += "3.服务器端口："+req.getServerPort()+"<br/>";
        str += "4.获取工程路径："+req.getContextPath()+"<br/>";
        str += "5.获取请求方法："+req.getMethod()+"<br/>";
        str += "6.获取客户端ip地址："+req.getRemoteHost()+"<br/>";
        str += "7.获取会话的id编号："+req.getRequestedSessionId()+"<br/>";

        resp.getWriter().write(str);
    }

    protected void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object str = req.getParameter("str");
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(str));
    }
}
