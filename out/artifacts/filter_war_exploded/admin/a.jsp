<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/21
  Time: 10:30
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
        System.out.println("a.jsp执行了");
    %>
    这是a.jsp页面
    <form action="loginServlet" method="post">
        <input type="submit" value="注销"/>
    </form>
</body>
</html>
