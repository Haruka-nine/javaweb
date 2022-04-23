package com.servlet;

import com.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies =req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]");
        }
        Cookie iWantCookie = CookieUtils.findCookie("key2",cookies);

        if (iWantCookie!=null)
        {
            resp.getWriter().write("找到了需要的Cookie");
        }

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("key1","value1");
        //通知客户端保存Cookie
        //通过响应头Set-Cookie告知客户端
        resp.addCookie(cookie);
        Cookie cookie2 = new Cookie("key2", "value2");
        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie创建成功");
    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Cookie的值是不支持”中文“的，也不支持空格、方括号、圆括号、等号、逗号、双引号、斜杠、？、@、:、;、
        //方案一
/*        Cookie cookie = new Cookie("key1","newValue1");
        resp.addCookie(cookie);*/
        //方案二
        Cookie  cookie = CookieUtils.findCookie("key2",req.getCookies());
        if (cookie!=null)
        {
            cookie.setValue("newValue2");
            resp.addCookie(cookie);
        }

        resp.getWriter().write("key1的Cookie已经修改好");


    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie!=null)
        {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("key1的cookie已经被删除");
        }
    }
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        cookie.setMaxAge(3600);//设置存活的秒数
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie");

    }
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }


}
