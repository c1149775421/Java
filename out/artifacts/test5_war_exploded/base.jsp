<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/8
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //动态获取base标签的值
    String basePath = request.getScheme()   //获取协议
            +"://"
            +request.getServerName()    //获取服务器IP地址
            +":"
            +request.getServerPort()    //获取端口号
            +request.getContextPath()   //获取工程路径
            +"/";
%>
<!--写base标签，永远固定相对路径跳转的结果（注意：其他的引入路径也会改变）-->
<base href="<%=basePath%>">