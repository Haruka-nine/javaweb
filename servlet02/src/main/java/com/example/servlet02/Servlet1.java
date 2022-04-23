package com.example.servlet02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("在servlet1中查看参数："+username);
        request.setAttribute("key1","柜台1的章");

//        请求转发必须要以斜杠打头

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

        requestDispatcher.forward(request,response);


    }

 
}
