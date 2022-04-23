<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%--静态包含base标签、css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
           $("#receiver").click(function () {
              return confirm("你确定要收货吗?");
           });
        });

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">我的订单</span>
    <div>
        <%--静态包含，登陆成功之后的页面--%>
        <%@include file="/pages/common/login_sucess_menu.jsp" %>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
                <c:if test="${order.status==0}">
                    <td>等待发货</td>
                </c:if>
                <c:if test="${order.status==1}">
                    <td><a id="receiver" href="orderServlet?action=receiverOrder&orderId=${order.orderId}">已发货，点击签收</a></td>
                </c:if>
                <c:if test="${order.status==2}">
                    <td>已收货</td>
                </c:if>

            </tr>
        </c:forEach>
    </table>


</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
