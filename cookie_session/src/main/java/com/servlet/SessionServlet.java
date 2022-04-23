package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session对象
        HttpSession session = req.getSession();
        //判断当前会话是否是新创建出来的
        boolean isNew = session.isNew();
        //获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的Session,他的id是:"+id+"<br/>");
        resp.getWriter().write("这个Session是否是新创建的:"+isNew+"<br/>");
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经向Session中保存了数据");
    }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取的key1的数据是:"+key1);

    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为:"+maxInactiveInterval+"秒");
    }
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置生命为-1代表永不超时（不建议使用，会导致服务器Session越来越多）
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("Session设置为3秒后超时");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.invalidate();
        resp.getWriter().write("Session马上超时");
    }
}
