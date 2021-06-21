<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/21
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/admin/base.jsp"%>
</head>
<body>
    <%
        System.out.println("login.jsp执行了");
        System.out.println("目标资源线程："+Thread.currentThread().getName());
    %>
    login.jsp登录页面
    <form action="loginServlet" method="get">
        用户名：<input type="text" name="username"/><br/>
        密  码：<input type="password" name="password"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
