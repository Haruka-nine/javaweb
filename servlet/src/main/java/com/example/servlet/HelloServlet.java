package com.example.servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");
//        1，获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
//        2,获取初始化参数init-param
        System.out.println("HelloServlet程序的初始化参数username的值是："+servletConfig.getInitParameter("username"));
        System.out.println("HelloServlet程序的初始化参数url的值是："+servletConfig.getInitParameter("url"));
//        3,获取ServletletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("3 service === hello servlet 被访问了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        /*System.out.println("get请求");
        System.out.println("post请求");*/

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy 方法");

    }
}