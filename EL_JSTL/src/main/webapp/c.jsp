<%@ page import="com.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: YYM
  Date: 2022/4/16
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("国哥好帅");
    person.setPhones(new String[]{"18610541354","18688886666","18699998888"});
    List<String> cities = new ArrayList<String >();
    cities.add("北京");
    cities.add("上海");
    cities.add("深圳");
    person.setCities(cities);
    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    pageContext.setAttribute("p",person);
%>
    输出Person:${p}<br>
    输出Person的name属性:${p.name} <br>
    输出Person的phone属性:${p.phones[2]} <br>
    输出Person的cities属性:${p.cities} <br>
    输出Person的map属性:${p.map} <br>
    输出Person的map某个key的值:${p.map.key1} <br>

</body>
</html>
