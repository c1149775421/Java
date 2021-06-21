package com.atguigu.filter;

import com.atguigu.pojo.User;
import com.atguigu.web.UserServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    int i = 0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");
        Object username = httpServletRequest.getSession().getAttribute("username");

        if(user == null){
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else{
            if("oushaojie".equals(username)){
                i+=1;
                System.out.println("管理员进入后台"+i);
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                httpServletRequest.getRequestDispatcher("/pages/manager/not_root.jsp").forward(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
