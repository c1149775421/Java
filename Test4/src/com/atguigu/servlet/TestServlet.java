package com.atguigu.servlet;

import com.atguigu.pojo.Test;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends BaseServlet {
    protected void test1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        Test test = new Test(username);
        Gson gson = new Gson();
        String json = gson.toJson(test);
        resp.getWriter().write(json);
    }

    protected void test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String single = req.getParameter("single");
        System.out.println(username);
        System.out.println(password);
        System.out.println(single);
        Test test = new Test(username,password,single);
        Gson gson = new Gson();
        String json = gson.toJson(test);
        resp.getWriter().write(json);
    }
}
