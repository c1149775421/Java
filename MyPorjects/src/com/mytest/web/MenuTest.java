package com.mytest.web;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuTest extends BaseServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        String action = req.getParameter("action");
//        System.out.println("action="+action);
//
//        if("menu".equals(action)){
//            //如果action正确就调用menu()
//            menu(req,resp);
//        }else{
//            Gson gson = new Gson();
//            Map<String,String> mm = new HashMap<>();
//            mm.put("status","404");
//            mm.put("msg","很抱歉，您访问的页面不存在，或已经被删除！！！");
//            String json = gson.toJson(mm);
//            resp.getWriter().write(json);
//        }
//    }

    protected void menu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<Map<String,String>> arrList = new ArrayList<>();

        Map<String,String> map = new HashMap<>();
        map.put("name","黄焖鸡");
        map.put("price","30");
        arrList.add(map);
        map = null;
        map = new HashMap<>();
        map.put("name","酸菜鱼");
        map.put("price","33");
        arrList.add(map);

        Gson gson = new Gson();
        String json = gson.toJson(arrList);
        resp.getWriter().write(json);
        System.out.println(arrList);
    }
}
