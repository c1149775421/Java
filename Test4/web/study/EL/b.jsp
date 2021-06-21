<%@ page import="com.atguigu.com.mytest.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();

        person.setName("国歌");
        person.setPhones(new String[]{
                "18610541354",
                "18688886666",
                "18699998888"
        });

        List<String> city = new ArrayList<String>();
        city.add("北京");
        city.add("上海");
        city.add("深圳");
        person.setCity(city);

        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>

    输出Person：${person}<br/>
<br/>
    ${person.name}<br/>
    ${person.phones[0]}<br/>
<br/>
    ${person.city}<br/>
    ${person.city[0]}<br/>
<br/>
    ${person.map}<br/>
    ${person.map.key1}<br/>
<br/>
    age属性值：${person.age}
</body>
</html>
