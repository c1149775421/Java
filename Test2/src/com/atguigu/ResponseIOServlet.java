package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //两种传输流不能同时使用，否则会报错
        //服务器的字符集设置为UTF-8，但是浏览器并没有改变字符集，会乱码
//            resp.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8字符集
//            resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //同时将 服务器、客户端、响应头 设置为UTF-8字符集（一定要在获取流对象之前设置才有效）
            resp.setContentType("text/html;charset=UTF-8");
        //字符流同于传输字符串，最常用
            PrintWriter writer = resp.getWriter();
        //往客户端回传 字符串 数据
            writer.println("国歌很帅!!!");

        //字节流是传输二进制数据，一般用于上传/下载文件
//            resp.getOutputStream();
    }
}
