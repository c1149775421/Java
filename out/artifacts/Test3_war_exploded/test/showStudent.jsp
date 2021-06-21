<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atguigu.com.mytest.pojo.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/5
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px solid black;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<%--    输出10个学生的信息表--%>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("stuList");
    %>
    <table>
        <tr>
            <th><%="id"%></th>
            <th><%="name"%></th>
            <th><%="age"%></th>
            <th><%="phone"%></th>
            <th><%="操作"%></th>
        </tr>
    <% for (Student student : studentList) { %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
            <td>删除/修改</td>
        </tr>
    <% } %>
    </table>
</body>
</html>
