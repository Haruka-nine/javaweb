package com.example.servlet02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI=>"+req.getRequestURI());

        System.out.println("url=>"+req.getRequestURL());

        System.out.println("客户端 ip地址=>"+req.getRemoteHost());
        /*在IDEA中，使用localhost访问时，得到的客户端ip地址是  127.0.0.1
        * 需要使用真实访问地址，才能得到真实的ip*/

        System.out.println("请求头=>"+req.getHeader("User-Agent"));


    }


}
