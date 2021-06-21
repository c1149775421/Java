<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>empty判断是否为空</h1>
    <%
        //1.值为null的时候，为空
        request.setAttribute("emptyNull",null);
        //2.值为空串的时候，为空
        request.setAttribute("emptyStr","");
        //3.值是Object类型数组，长度为零的时候
        request.setAttribute("emptyArr",new Object[]{});
        //4.list集合，元素个数为零
        List<String> list = new ArrayList<>();
        request.setAttribute("emptyList",list);
        //5.map集合，元素个数为零
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("emptyMap",map);
    %>
    ${empty emptyNull}<br/>
    ${empty emptyStr}<br/>
    ${empty emptyArr}<br/>
    ${empty emptyList}<br/>
    ${empty emptyMap}<br/>
    <hr>
    ${12 == 12 ? "真的":"假的"}<br/>
</body>
</html>
