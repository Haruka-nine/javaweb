package com.service;

import com.pojo.*;


import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart ,Integer userId);
    public List<Order> showMyOrders(Integer userId);
    public List<OrderItem> showOrderDetail(String orderId);
    public List<Order>   showAllOrders();
    public void sendOrder(String orderId);
    public  void receiverOrder(String orderId);

}
