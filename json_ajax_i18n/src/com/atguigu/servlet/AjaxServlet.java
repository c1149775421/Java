package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    int i1 = 0,i2 = 0,i3 = 0,i4 = 0,i5 = 0;
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i1+=1;
        System.out.println("javaScriptAjax 请求了"+i1+"次");
        Person person = new Person(1,"国哥");
        Gson gson = new Gson();
        String personToJsonStr = gson.toJson(person);
        resp.getWriter().write(personToJsonStr);
    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i2+=1;
        System.out.println("jQueryGet 请求了"+i2+"次");
        Person person = new Person(2,"康师傅");
        Gson gson = new Gson();
        String personToJsonStr = gson.toJson(person);
        resp.getWriter().write(personToJsonStr);
    }
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i3+=1;
        System.out.println("jQueryPost 请求了"+i3+"次");
        Person person = new Person(3,"国康");
        Gson gson = new Gson();
        String personToJsonStr = gson.toJson(person);
        resp.getWriter().write(personToJsonStr);
    }
    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i4+=1;
        System.out.println("jQueryGetJSON 请求了"+i4+"次");
        Person person = new Person(4,"国康组");
        Gson gson = new Gson();
        String personToJsonStr = gson.toJson(person);
        resp.getWriter().write(personToJsonStr);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        i5+=1;
        System.out.println("jQuerySerialize 请求了"+i5+"次");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Person person = new Person(5,"国康组合");
        Gson gson = new Gson();
        String personToJsonStr = gson.toJson(person);
        resp.getWriter().write(personToJsonStr);
    }
}
