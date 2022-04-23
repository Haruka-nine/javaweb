package com.service;

import com.pojo.Order;
import com.pojo.OrderItem;
import com.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest2 {
    private  OrderService orderService = new OrderServiceImpl();
    @Test
    public void showMyOrders() {
        List<Order> list = orderService.showMyOrders(1);
        for (Order order : list) {
            System.out.println(order);
        }

    }

    @Test
    public void showOrderDetail() {
        List<OrderItem> orderItems = orderService.showOrderDetail("16505978193095");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void showAllOrders() {
        List<Order> list = orderService.showAllOrders();
        for (Order order : list) {
            System.out.println(order);
        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("1234567896");
    }

    @Test
    public void receiverOrder() {
        orderService.receiverOrder("1234567896");
    }
}