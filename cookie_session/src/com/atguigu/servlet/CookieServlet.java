package com.atguigu.servlet;

import com.atguigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1","value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);

        //1.创建Cookie对象
        Cookie cookie2 = new Cookie("key2","value2");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie2);

        //1.创建Cookie对象
        Cookie cookie3 = new Cookie("key3","value3");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie3);
        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName()方法返回Cookie的key名，getValue()方法返回Cookie的值
            resp.getWriter().write("Cookie["+ cookie.getName()+"="+cookie.getValue() +"]<br/>");
        }
        Cookie iWantCookie = CookieUtils.findCookie("key1",cookies);
        if(iWantCookie != null){
            resp.getWriter().write("找到了需要的Cookie");
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一：
        //1.先创建一个要修改的同名Cookie对象
        //2.在构造器，同时赋予新的Cookie值
        Cookie cookie = new Cookie("key1","newValue1");
        //3.调用response.addCookie(cookie)  通知客户端保存修改
        resp.addCookie(cookie);

        //方案二：(如果有中文，要使用BASE64编码)
        //1.先查找到要修改的Cookie对象
        Cookie cookie2 = CookieUtils.findCookie("key2",req.getCookies());
        if(cookie != null){
            //2.调用setValue()方法赋予新的Cookie值
            cookie2.setValue("newValue2");
            //3.调用response.addCookie(cookie)  通知客户端保存修改
            resp.addCookie(cookie2);
        }
        resp.getWriter().write("key1的Cookie修改了");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key3",req.getCookies());
        if(cookie != null){
            //调用setMaxAge(0)
            cookie.setMaxAge(0);//表示马上删除
            //调用response.addCookie(cookie)
            resp.addCookie(cookie);
            resp.getWriter().write("key3立刻删除");
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie存活一小时");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

}
