package com.atguigu.ApplicationMain.Controller.book.FilterFiles;

import com.atguigu.ApplicationMain.myTools.MysqlTest;
import com.atguigu.ApplicationMain.myTools.RedisClient;
import com.atguigu.ApplicationMain.myTools.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

public class FilterTest implements javax.servlet.Filter {
    @Autowired
    public RedisClient redisClient;
    @Autowired
    public Utils utils;
    @Autowired
    public MysqlTest mysqlTest;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
//        String token = req.getParameter("token");
//        System.out.println("Filter："+token);
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy(){
    }
}
