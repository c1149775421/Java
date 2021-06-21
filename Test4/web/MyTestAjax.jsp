<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyTest</title>
    <%@include file="/common/base.jsp"%>
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                var us = $("#ttt").val();
                $.getJSON("testServlet","action=test1&username="+us,function (data) {
                    $("#msg").html("姓名：" + data.username);
                    $("#ttt").val("");
                });
            });

            // ajax请求--表单序列化
            // serialize()可以把表单中所有表单项的内容都获取到，并以name=value&name=value的形式进行拼接
            $("#submit").click(function(){
                // 把参数序列化
                // alert($("#form01").serialize());
                $.getJSON("testServlet","action=test2&"+$("#form01").serialize(),function (data) {
                    $("#msg").html("姓名：" + data.username + "|密码：" + data.password + "|下拉单选：" + data.single);
                });
                // alert("serialize()");
            });

        })
    </script>
</head>
<body>
    <input type="text" id="ttt"/>
    <button id="btn">发起请求</button>
    <div id="msg"></div>

    <br/><br/>

    <form id="form01" >
        用户名：<input name="username" type="text" /><br/>
        密码：<input name="password" type="password" /><br/>
        下拉单选：<select name="single">
        <option value="Single">Single</option>
        <option value="Single2">Single2</option>
    </select><br/>
        下拉多选：
        <select name="multiple" multiple="multiple">
            <option selected="selected" value="Multiple">Multiple</option>
            <option value="Multiple2">Multiple2</option>
            <option selected="selected" value="Multiple3">Multiple3</option>
        </select><br/>
        复选：
        <input type="checkbox" name="check" value="check1"/> check1
        <input type="checkbox" name="check" value="check2" checked="checked"/> check2<br/>
        单选：
        <input type="radio" name="radio" value="radio1" checked="checked"/> radio1
        <input type="radio" name="radio" value="radio2"/> radio2<br/>
    </form>
    <button id="submit">提交--serialize()</button>
</body>
</html>