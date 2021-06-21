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
    <title>Title</title>
</head>
<body>
    <h1>这是scope.jsp页面</h1>
<%--    <form method="get" action="scope.jsp">--%>
<%--    <input type="text" name="name">--%>
<%--    <input type="submit" value="提交">--%>
<%--    </form>--%>
    <%
        //往四个域中分别保存了数据
//        Object name = request.getParameter("name");
        pageContext.setAttribute("key","pageContextValue");//当前页面范围内有效
        request.setAttribute("key","requestValue");//一次请求内有效
        session.setAttribute("key","sessionValue");//一个会话范围内有效(保存在浏览器，直到关闭浏览器)
        application.setAttribute("key","applicationValue");//整个web工程范围内都有效(只要web工程不停止，数据一直都在)
    %>

    pageContext域中是否有值：<%=pageContext.getAttribute("key")%><br>
    request域中是否有值：<%=request.getAttribute("key")%><br>
    session域中是否有值：<%=session.getAttribute("key")%><br>
    application域中是否有值：<%=application.getAttribute("key")%><br>
    <%
        System.out.println("scope.jsp请求转发");
//        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>
<%--    请求转发
        page属性 设置请求转发的目标路径
--%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>

</body>
</html>
