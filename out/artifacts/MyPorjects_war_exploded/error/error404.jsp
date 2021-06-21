<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/8
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String basePath = request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";
//        System.out.println(basePath);
    %>
    很抱歉，您访问的页面不存在，或已经被删除！！！
    <a href="<%=basePath%>index.jsp">返回首页</a>
</body>
</html>
