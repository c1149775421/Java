<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //默认顺序是按照域的范围，从小到大输出
        /**
         * pageScope
         * requestScope
         * sessionScope
         * applicationScope
         * 以上四种方法可以选择需要的域数据输出(精确选择)
         */
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    ${pageScope.key}<br/>
    ${requestScope.key}<br/>
    ${sessionScope.key}<br/>
    ${applicationScope.key}<br/>
</body>
</html>
