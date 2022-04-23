<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/15
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th
        {
            border: 1px red solid;

        }
    </style>
</head>
<body>
<%--jsp输出一个表格，里面有10个学生信息--%>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("stuList");
%>
<table>
    <td>编号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>电话</td>
    <td>操作</td>

    <%
        for (Student student:studentList)
        {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getPhone()%></td>
        <td>操作、删除</td>
    </tr>


    <%
        }
    %>
</table>


</body>
</html>
