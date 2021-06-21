<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <%@include file="/common/base.jsp"%>
      <style type="text/css">
          body{
              text-align: center;
          }
          a{
              text-decoration: none;
              width: 30px;
              height: 20px;
              background-color: aqua;
              padding: 10px;
          }
          div{
              margin-top: 100px;
          }
      </style>
  </head>
  <body>
<%--      <jsp:forward page="study/Upload/upload.jsp"></jsp:forward>--%>
<%--      <%--%>
<%--        response.sendRedirect(request.getContextPath()+"/test/test1.jsp");--%>
<%--      %>--%>
<div>
        <a href="test/test1.jsp">华夏不停转</a>
        <a href="study/Upload/upload.jsp">上传文件</a>
        <a href="study/EL/pageContext.jsp">pageContext</a>
        <a href="MyTestAjax.jsp">Ajax请求</a>
</div>
  </body>
</html>
