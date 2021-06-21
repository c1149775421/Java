<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

	<%--静态包含 base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%--静态包含manager管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="pageNo" value="${param.pageNo}"/>
				<input type="hidden" name="action" value="${empty requestScope.book?"add":"update"}"/>
				<input type="hidden" name="id" value="${requestScope.book.id}"/>
<%--
				方案一：通过 请求参数 method 带过去的值判断
				<input type="hidden" name="action" value="${param.method}"/>
				方案二：判断 请求参数 id 是否带值过去
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}"/>
				方案三：判断 Request域中 是否有值
				<input type="hidden" name="action" value="${empty requestScope.book?"add":"update"}"/>
--%>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>


		<%--静态包含--%>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>