package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletConfig().getServletContext();

        String username = context.getInitParameter("username");
        System.out.println(username);
        System.out.println(context.getInitParameter("password"));
//        获取当前工程路径
        System.out.println("当前工程路径:"+context.getContextPath());
//        或者工程部署在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径:"+context.getRealPath("/"));
        System.out.println("工程下css目录部署的路径:"+context.getRealPath("/css"));
        System.out.println("工程下img目录下1.jpg部署的路径:"+context.getRealPath("/imgs/1.jpg"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
