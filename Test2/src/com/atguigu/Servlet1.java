package com.atguigu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数："+username);
        //给参数盖一个章并传递到Servlet2去查看（属性共享）
        req.setAttribute("key1","这是Servlet1的盖章");
        //问路：去Servlet2该怎么走？(设置路径)
        //注意：请求转发必须要以 / 开头，斜杠表示http://ip:port/工程名/ ，映射到IDEA代码的web目录下。
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //转到Servlet2(执行跳转)
        requestDispatcher.forward(req,resp);
    }
}
