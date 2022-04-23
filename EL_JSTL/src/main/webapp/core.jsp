<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/16
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<c:set/>标签可以往域中保存数据
域对象.setAttribute(key,value);
scope 属性设置保存到那个域
    page表示PageContext域
    request表示Request域
    session表示Session域
    application表示ServletContest域
    var设置key是多少
    value设置value是多少
--%>

保存之前：${pageScope.abc} <br>
<c:set scope="page" var="abc" value="abcvalue" />
保存之前：${pageScope.abc}

<%--
    if标签做if判断
    <c:if/>
    test属性表示判断的条件（使用EL表达式输出）
--%>
    <c:if test="${12==12}">
        <h1>12等于12</h1>
    </c:if>
<%--
    多路判断
    <c:choose>
    <c:when>
    <c:otherwise>
    choose标签开始选择判断
    when标签表示每一种判断情况
        test属性表示当前这种判断情况的值
    和swith接近，但不需要break；
--%>
    <%
        request.setAttribute("height",198);
    %>
    <c:choose>

        <c:when test="${requestScope.height>190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h2>还可以</h2>
        </c:when>

        <c:otherwise>
            <h2>剩下小于170的情况</h2>
        </c:otherwise>

    </c:choose>

</body>
</html>
