package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter(){
        System.out.println("1.Filter的构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的初始化方法");
        //1.获取Filter的名称
        System.out.println("filter-name的值是："+filterConfig.getFilterName());
        //2.获取在xml中配置的初始化参数
        System.out.println("初始化参数username的值是："+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+filterConfig.getInitParameter("url"));
        //3.获取ServlerContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter方法，专门用于拦截请求(过滤响应)。(可以做权限检查)
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的过滤器方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            //如果用户名为空，请求转发到登录页面
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序通过，继续执行(这一步很重要，如果少了这一步就跳过程序了)
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的销毁方法");
    }
}
