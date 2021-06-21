<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/24
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JavaWeb程序</title>
    <%@include file="base.jsp"%>
  </head>
  <body>
<%--      <h1>这是我的第一个JavaWeb程序</h1>--%>
<%--      <%--%>
<%--        //偷懒的方法，减少代码量--%>
<%--        pageContext.setAttribute("req",request);--%>
<%--      %>--%>
<%--      1.协议：${req.scheme}<br/>--%>
<%--      2.服务器ip：${req.serverName}<br/>--%>
<%--      3.服务器端口：${req.serverPort}<br/>--%>
<%--      4.获取工程路径：${pageContext.request.contextPath}<br/>--%>
<%--      5.获取请求方法：${pageContext.request.method}<br/>--%>
<%--      6.获取客户端ip地址：${pageContext.request.remoteHost}<br/>--%>
<%--      7.获取会话的id编号：${pageContext.session.id}<br/>--%>
      <%
        request.getRequestDispatcher("/test").forward(request,response);
      %>
<%--      <jsp:forward page="/test"></jsp:forward>--%>
  </body>
</html>
