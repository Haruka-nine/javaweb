package com.example.servlet02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        System.out.println("兴趣爱好"+ Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        设置请求的字符集是utf-8，从而解决post请求中文乱码问题
//        要在获取请求参数之前调用才有效，如果先req.getParameter("username");再进行api调用的话，依旧会乱码
        System.out.println("post");
        String username =req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        System.out.println("兴趣爱好"+ Arrays.asList(hobby));
    }
}
