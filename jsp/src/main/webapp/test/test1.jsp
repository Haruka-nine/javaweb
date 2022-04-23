<%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/15
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table
        {
            width: 600px;

        }
    </style>
</head>
<body>
<%--在jsp页面输出九九乘法表--%>
<h1 align="center">九九乘法表</h1>
   <table align="center">
       <% for (int i = 1; i <= 9; i++) { %>
       <tr>
           <%
               for (int j = 1; j <= i; j++) {
           %>
            <td><%=i+"X"+j+"="+(i*j)%></td>
           <%
               }
           %>
       </tr>


       <%
           }
       %>
   </table>


</body>
</html>
