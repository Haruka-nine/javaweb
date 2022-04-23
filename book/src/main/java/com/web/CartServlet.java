package com.web;

import com.google.gson.Gson;
import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count=WebUtils.parseInt(req.getParameter("count"),0);
        //获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null)
        {
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }



    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* System.out.println("加入购物车");
        System.out.println("商品编号"+req.getParameter("id"));*/
        //获取请求的参数，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book得到图书信息
        Book book = bookService.queryBookById(id);
        //将CartItem添加到商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null)
        {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastname",cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));

        //重定向到商品页面

    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart!=null)
        {
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));

    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取购物车对象
       Cart cart = (Cart) req.getSession().getAttribute("cart");
       if (cart!=null)
       {
           cart.clear();
           resp.sendRedirect(req.getHeader("Referer"));
       }
    }

    protected void ajaxAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* System.out.println("加入购物车");
        System.out.println("商品编号"+req.getParameter("id"));*/
        //获取请求的参数，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book得到图书信息
        Book book = bookService.queryBookById(id);
        //将CartItem添加到商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null)
        {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastname",cartItem.getName());
        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastname",cartItem.getName());
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);


    }
}
