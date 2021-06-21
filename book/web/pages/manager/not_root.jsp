<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>权限不够</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        div{
            text-align: center;
            margin-top: 200px;
            color: red;
            font-size: 30px;
        }
        a{
            /*text-decoration: none;*/
            font-size: 25px;
            color: dodgerblue;
        }
    </style>
</head>
<body>
    <div>很抱歉，你没有管理员权限!
        <a href="index.jsp">回到首页</a>
    </div>
</body>
</html>
