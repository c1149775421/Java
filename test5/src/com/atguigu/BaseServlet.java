package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected  void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String action = req.getParameter("action");

        if(action.isEmpty()){
            resp.getWriter().write("action参数不能为空");
            return;
        }

        try {
            Method mod = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            mod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
