<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("a.a.a","aaavalue");
        map.put("b+b+b","bbbvalue");
        map.put("ccc","cccvalue");
        request.setAttribute("map",map);
    %>
    ${map["a.a.a"]}<br/>
    ${map["b+b+b"]}<br/>
    ${map.ccc}<br/>
</body>
</html>
