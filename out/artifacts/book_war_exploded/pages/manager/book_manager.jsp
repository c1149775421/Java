<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%--静态包含 base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				//在事件的function函数中有一个this对象，表示当前正在响应的dom对象。
				return confirm("确定要删除["+$(this).parent().parent().find("td:first").text()+"]吗?");
				//return false;//阻止元素默认行为===不提交请求
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%--静态包含manager管理模块的菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
<%--
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update">修改</a></td>
--%>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
<%--
				<td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>
--%>
			</tr>	
		</table>

		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>


	</div>


	<%--静态包含--%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>