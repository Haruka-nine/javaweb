package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();

        context.setAttribute("key1","value1");
        System.out.println("Context1中数据域key1的值:"+context.getAttribute("key1"));

    }


}
