package com.atguigu.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MenuServlet extends BaseServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//        String action = req.getParameter("action");
//        if("menu".equals(action)){
//            menu(req,resp);
//        }
//    }

        protected void menu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setHeader("Access-Control-Allow-Origin", "*");
        //接受请求的参数
        Map<String, String[]> select = req.getParameterMap();
        Set<Map.Entry<String ,String[]>> set=select.entrySet();
        Iterator<Map.Entry<String ,String[]>> it=set.iterator();

        Map<String,String[]> map = new HashMap<>();

        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();

            System.out.println("KEY:"+entry.getKey());
            for (String i : entry.getValue()) {
                System.out.println(i);
            }
            map.put(entry.getKey(),entry.getValue());
        }
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }
}
