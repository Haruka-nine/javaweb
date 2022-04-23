package com.dao;

import com.pojo.Order;

import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public int changeOrderStatus(String orderId,int status);

    public List<Order> queryOrderByUserId(int userId);
}
