<%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/14
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp页面</h1>
<%
    //往四个域中都分别保存了数据
    pageContext.setAttribute("key","pageContext"); //当前jsp页面范围内有效
    request.setAttribute("key","request");         //一次请求内有效
    session.setAttribute("key","session");         //一个会话范围有效（打开浏览器到关闭浏览器）
    application.setAttribute("key","application"); //整个web工程（只要web工程不停止，数据都在）
%>
    pageContext域是否有值<%= pageContext.getAttribute("key")%> <br>
    request域是否有值<%= request.getAttribute("key")%> <br>
    session域是否有值<%= session.getAttribute("key")%> <br>
    application域是否有值<%= application.getAttribute("key")%> <br>
    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>




</body>
</html>
