<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/14
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error500.jsp"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--声明类的属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String,Object> map;
%>
<%--定义静态代码块--%>

<%!
    static
    {
        map = new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

    }
%>
<%--声明类方法--%>
<%!
    public int abc()
    {
        return 12;
    }
%>

<%!
    public static class A
    {
        private Integer id = 12;
        private String  abc = "abc";
    }
%>
<%=

12
%>

<%
    int i =12;
    if (i==12)
    {
        System.out.println("kirito");
    }
%>



</body>
</html>
