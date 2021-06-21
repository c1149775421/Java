package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1请求重定向");
        //设置响应状态码
//        resp.setStatus(302);
        //设置响应头，说明新地址在哪里
//        resp.setHeader("Location","http://localhost:8082/Test2/response2");

        //请求重定向第二种方法（推荐使用）
        resp.sendRedirect("http://localhost:8082/Test2/response2");
    }
}
