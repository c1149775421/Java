<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/5
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title2</title>
</head>
<body>
    <%
        System.out.println("成功转发到scope2.jsp");
    %>
    <h1>这是scope2.jsp页面</h1>
    pageContext域中是否有值：<%=pageContext.getAttribute("key")%><br>
    request域中是否有值：<%=request.getAttribute("key")%><br>
    session域中是否有值：<%=session.getAttribute("key")%><br>
    application域中是否有值：<%=application.getAttribute("key")%><br>
</body>
</html>
