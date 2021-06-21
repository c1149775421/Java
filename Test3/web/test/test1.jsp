<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/5
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 750px;
        }
    </style>
</head>
<body>
    <center><h1>九九乘法表</h1></center>
    <table align="center">
    <% for (int i = 0;i <= 9;i++){ %>
        <tr>
            <% for (int j = 1;j <= i;j++){ %>
            <td><%=j + "x" + i + "=" + (i*j)%></td>
            <% } %>
        </tr>
    <% } %>
    </table>
</body>
</html>
