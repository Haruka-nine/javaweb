package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.*;
import com.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Order order =new Order(orderId,simpleDateFormat.format(new Date()),cart.getTotalPrice(),0,userId);

        orderDao.saveOrder(order);
        int i =12/0;
        //遍历购物车中每一个商品项
        for (Map.Entry<Integer, CartItem>entry :cart.getItems().entrySet())
        {
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(),cartItem.getTotalPrice(),orderId);

            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        List<Order> orders = orderDao.queryOrderByUserId(userId);
        return orders;
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemByOrderId(orderId);
        return orderItems;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = orderDao.queryOrders();
        return orders;
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);

    }

    @Override
    public void receiverOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);

    }
}
