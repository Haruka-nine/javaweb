<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/16
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--遍历1到10--%>
    <table>
        <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
        </c:forEach>
    </table>
    <hr>

    <%
        request.setAttribute("arr",new String[]{"123456789","18625165151"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item} <br>
    </c:forEach>
    <hr>
    <%
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        request.setAttribute("map",map);

    %>
    <c:forEach items="${requestScope.map}" var="entry">
       <h1>${entry}</h1>
    </c:forEach>
    <hr>
    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 1; i <=10; i++) {
            studentList.add(new Student(i,"username"+i,"pass"+i,18+i,"phone"+i));
        }
        request.setAttribute("stus",studentList);
    %>

    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
<%--        varSratus属性表示当前遍历到数据的状态--%>
    <c:forEach begin="2" end="7" step="2" varStatus="status" items="${requestScope.stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.last}</td>
        </tr>
    </c:forEach>
    </table>




</body>
</html>
