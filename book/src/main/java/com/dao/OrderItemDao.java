package com.dao;

import com.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemByOrderId(String orderId);
}
