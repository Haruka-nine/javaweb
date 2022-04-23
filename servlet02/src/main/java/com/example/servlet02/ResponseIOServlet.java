package com.example.servlet02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        方法1
        //设置服务器的字符集是UTF-8
        response.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8的字符集
        response.setHeader("Content-Type","text/html;charset-UTF-8");*/

        //方法2
        //这个API可以直接一起设置服务器和浏览器的字符集
        //此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html;charset=UTF-8");


        PrintWriter writer = response.getWriter();//ISO-8859-1默认
        writer.write("国哥很帅");


    }

}
