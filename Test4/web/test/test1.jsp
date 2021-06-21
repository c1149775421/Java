<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/base.jsp"%>
    <script src="script/jquery-1.7.2.js"></script>
    <style type="text/css">
        body{
            text-align: center;
        }
        video{
            margin-top: 100px;
            width: 800px;
            height: 360px;
        }
    </style>
</head>
<body>
    <video id="veo" src="static/video/huaxia.mp4" controls="controls"></video>
</body>
</html>
