<%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/22
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是登陆页面，login.jsp页面
<form action="http://localhost:8080/filter/loginServlet" method="get">
    用户名:<input type="text" name="username"> <br>
    密码: <input type="password" name="password"> <br>
    <input type="submit">
</form>
</body>
</html>
