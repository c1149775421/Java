package com.atguigu.web;

import com.atguigu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//该类已停止使用
public class ManagerLogin extends BaseServlet {
    protected void rootLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        if("oushaojie".equals(loginUser.getUsername()) && "oushaojie".equals(loginUser.getPassword())){
            resp.sendRedirect(req.getContextPath()+"/pages/manager/manager.jsp");
        }else{
            req.getRequestDispatcher("/pages/manager/not_root.jsp").forward(req,resp);
        }
    }
}
