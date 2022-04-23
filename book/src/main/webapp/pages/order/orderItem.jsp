<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%--静态包含base标签、css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
			<div>
				<div>
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
					<a href="${requestScope.last}">返回</a>
				</div>
			</div>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>书名</td>
				<td>数量</td>
				<td>价格</td>
				<td>总价</td>
			</tr>		

			<c:forEach items="${requestScope.orderItems}" var="item">

				<tr>
					<td>${item.name}</td>
					<td>${item.count}</td>
					<td>${item.price}</td>
					<td>${item.totalPrice}</td>
				</tr>

			</c:forEach>

			

		</table>
		
	
	</div>
	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>