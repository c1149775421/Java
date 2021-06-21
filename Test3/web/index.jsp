<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/4
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--data: jsp声明脚本--%>
        <%--1.声明类的属性--%>
        <%!
            private Integer id;
            private String name;
            private static Map<String,Object> map;
        %>
        <%--2.声明static静态代码块--%>
        <%!
            static {
                map = new HashMap<String,Object>();
                map.put("key1","value1");
                map.put("key2","value2");
                map.put("key3","value3");
            }
        %>
        <%--3.声明类的方法--%>
        <%!
            public int abc(){
                return 12;
            }
        %>
        <%--4.声明内部类--%>
        <%!
            public static class A{
                private Integer id = 12;
                private String abc = "abc";
            }
        %>

<%--data: jsp表达式脚本--%>
        <%--1.输出整型--%>
        <%=12 %><br>
        <%--2.输出浮点型--%>
        <%=12.12 %><br>
        <%--3.输出字符型--%>
        <%="这是字符串" %><br>
        <%--4.输出对象--%>
        <%=map%><br>
        <%="这是对象返回值："+request.getParameter("username") %><br>

<%--data: jsp代码脚本--%>
        <%
            int i = 12;
            if(i == 12){
                System.out.println("等于12");
            }else{
                System.out.println("不等于12");
            }
        %>

        <table border="1" cellspacing="0">
        <%
            for(int j = 0;j < 5;j++){
        %>
            <%--代码脚本可以与表达式脚本组合使用--%>
            <tr>
                <td>第<%=j + 1%>行</td>
            </tr>
        <%  }  %>
        </table>
<%--翻译后Java文件中_jspService方法内的代码都可以写--%>
        <%
            String username = request.getParameter("username");
            System.out.println("用户名的请求参数值是："+username);
        %>
<%--
    jsp注释可以注掉jsp页面上的一切
--%>
<jsp:forward page="output.jsp"></jsp:forward>
</body>
</html>
