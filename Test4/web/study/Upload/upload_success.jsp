<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/7
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传成功</title>
    <%@include file="/common/base.jsp"%>
</head>
<body>
    <center>
        <h2>上传成功</h2>
        <%
            String value = (String) request.getAttribute("value");
            String fileName = (String) request.getAttribute("fileName");
        %>
        用户名：<%=value%><br />
        文件名：<%=fileName%><br />
        <button><a href="study/Upload/upload.jsp">继续上传</a></button>
    </center>
</body>
</html>
