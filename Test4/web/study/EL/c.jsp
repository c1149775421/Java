<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/6
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    12等于12：${12 eq 12}<br/>
    12不等于12：${12 ne 12}<br/>
    11小于12：${11 lt 12}<br/>
    11大于12：${11 gt 12}<br/>
    12小于等于12：${12 le 12}<br/>
    12大于等于11：${12 ge 11}<br/>
    <hr>
    ${12 == 12 and 12 > 11} 或 ${12 == 12 && 12 > 11}<br/>
    ${12 == 12 or 12 < 11} 或 ${12 == 12 || 12 < 11}<br/>
    ${not true} 或 ${! true}<br/>
    <hr>
    ${12 + 12}<br/>
    ${12 - 12}<br/>
    ${12 * 12}<br/>
    ${18 / 12} 或 ${18 div 12}<br/>
    ${144 % 10} 或 ${144 mod 10}<br/>
</body>
</html>
