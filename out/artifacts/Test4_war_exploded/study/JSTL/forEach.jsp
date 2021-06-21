<%@ page import="java.util.*" %>
<%@ page import="com.atguigu.com.mytest.pojo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
            border: 2px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<%--
    遍历1-10输出
        begin  属性设置开始的索引
        end  属性设置结束的索引
        var  属性表示循环的变量(也表示当前遍历到的数据)
--%>
    <table>
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${ i }行</td>
        </tr>
    </c:forEach>
    </table>
    <hr>

<%--
    遍历Object数组
        items表示遍历的数据源(遍历的集合)
        var表示当前遍历到的数据
--%>
    <%
        request.setAttribute("arr",new String[]{"18610541354","18688886666","18699998888"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        <h3>${ item }</h3>
    </c:forEach>
    <hr>

    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
//        for (Map.Entry<String,Object> entry : map.entrySet()){
//            System.out.println(entry);
//        }
//        System.out.println();
        request.setAttribute("map",map);
    %>
    <table>
        <tr>
            <th>All</th>
            <th>Key</th>
            <th>Value</th>
        </tr>
    <c:forEach items="${requestScope.map}" var="i">
        <tr>
            <td>${ i }</td>
            <td>${ i.key }</td>
            <td>${ i.value }</td>
        </tr>
    </c:forEach>
    </table>
    <hr>

<%--
    遍历List集合---list中存放Student类，属性有：编号，用户名，密码，年龄，电话信息
--%>
    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 1; i <= 10; i++) {
            studentList.add(new Student(i,"name"+i,"pass"+i,18+i,"phone"+i));
        }
        request.setAttribute("stus",studentList);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
<%--
    items  表示遍历的集合
    var  表示遍历到的数据
    begin  表示遍历开始的索引
    end  表示遍历结束的索引值
    step  表示遍历的步长值(默认为1，设置2就隔行输出了)
    varStatus  表示当前遍历到的数据状态
--%>
    <c:forEach items="${requestScope.stus}" var="stu" varStatus="status">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.current}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
