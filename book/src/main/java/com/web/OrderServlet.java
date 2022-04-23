package com.web;

import com.dao.impl.BaseDao;
import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.User;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import com.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user==null)
        {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = user.getId();
        String orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> allOrders = orderService.showAllOrders();
        req.setAttribute("allOrders",allOrders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("orderItems",orderItems);
        req.setAttribute("last",req.getHeader("Referer"));
        req.getRequestDispatcher("/pages/order/orderItem.jsp").forward(req,resp);
    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User)req.getSession().getAttribute("user");
        List<Order> list = orderService.showMyOrders(user.getId());
        req.setAttribute("orders",list);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiverOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
