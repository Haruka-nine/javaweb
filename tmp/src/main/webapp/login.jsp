<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="http://localhost:8080/tmp/loginServlet" method="get">
    用户名:<input type="text" name="username" id=""> <br>
    验证码:<input type="text" style="width: 80px"  name="code">
    <img src="http://localhost:8080/tmp/kaptcha.jpg" style="width: 100px;height: 28px;" alt=""> <br>
    <input type="submit" value="登陆">
</form>
</body>
</html>