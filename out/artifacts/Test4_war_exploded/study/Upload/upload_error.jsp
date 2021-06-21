<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/26
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传失败</title>
    <%@include file="/common/base.jsp"%>
</head>
<body>
        <center>
            <h2>上传失败</h2>
            <%
                String value = (String) request.getAttribute("value");
            %>
            <c:if test="${value.length()>0}">
                用户名：<%=value%><br />
            </c:if>
            <p>未选择文件</p>
            <button><a href="study/Upload/upload.jsp">重新上传</a></button>
        </center>
</body>
</html>
