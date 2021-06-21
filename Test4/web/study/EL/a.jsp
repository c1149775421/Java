<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //EL表达式按照域的顺序输出，优先级是从小到大的
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    jsp表达式输出：<%=request.getAttribute("key")%><br/>
    EL表达式输出：${key}<br/>
</body>
</html>
