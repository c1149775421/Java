package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session对象
        HttpSession session = req.getSession();
        //判断当前Session对象，是否新创建出来的
        boolean aNew = session.isNew();
        //获取Session会话发唯一标识
        String id = session.getId();

        resp.getWriter().write("id是："+id+"<br/>");
        resp.getWriter().write("这个Session是否新创建的："+aNew+"<br/>");
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往Session中保存了数据");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取到key1的数据是："+attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为："+ maxInactiveInterval +"秒");
    }

    protected void life3s(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //设置当前Session3秒后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session已经设置3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //Session会话立刻超时
        session.invalidate();
        resp.getWriter().write("Session已经立刻销毁");
    }
}
