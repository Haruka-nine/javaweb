package com.example.servlet02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key1","values");
        System.out.println("曾到此一游");
/*        //请求从定向的方法1
        //设置响应状态码302，表示从定向
        response.setStatus(302);
        //设置响应头，说明新的地址在哪里
        response.setHeader("Location","http://localhost:8080/servlet02/response2");*/
        //请求从定向的第二种方法
        response.sendRedirect("http://localhost:8080/servlet02/response2");

    }


}
