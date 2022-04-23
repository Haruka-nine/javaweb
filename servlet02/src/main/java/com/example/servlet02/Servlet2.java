package com.example.servlet02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("在柜台2中查看参数"+username);

        Object key1 = request.getAttribute("key1");

        System.out.println("柜台1是否有章"+key1);
        System.out.println("servlet2自己的业务");

    }

    }

