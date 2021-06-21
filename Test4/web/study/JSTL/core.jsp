<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<c:set />的作用：
    set标签可以往域中保存数据
    域对象.setAttribute(key,value);
    scope属性设置保存到哪个域
        page表示pageContext域(默认值)
        request表示Request域
        session表示Session域
        application表示ServletContext域
    var属性设置key的值
    value设置属性的值
--%>

    保存之前：${requestScope.abc}<br/>
    <c:set scope="request" var="abc" value="abcValue"/>
    保存之后：${requestScope.abc}<br/>
    <hr>
<%--
    <c:if />标签用来做if判断
        test属性表示判断的条件(使用EL表达式输出)
        不支持if  else  的方式，如果需要就判断两次吧
--%>
    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>
    <hr>
<%--
    <c:choose> <c:when> <c:otherwise>标签
    作用：多路判断。跟switch ... case ... default非常接近
    choose标签开始选择判断
    when标签表示每一种判断情况
        test属性表示当前这种情况判断的值
    otherwise标签表示其他的情况
    注意：
        1.标签里不能使用HTML注释，要使用jsp注释
        2.when标签的父标签一定要是choose标签
--%>
    <%
        request.setAttribute("height",174);
    %>
    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h2>大于180</h2>
        </c:when>
        <c:when test="${requestScope.height > 170}">
            <h2>大于170</h2>
        </c:when>
        <c:otherwise>
            <h2>小于170</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
