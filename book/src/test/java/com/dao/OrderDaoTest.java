package com.dao;

import com.dao.impl.OrderDaoImpl;
import com.pojo.Order;
import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Date currentDate = new Date();
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化当前日期
        SimpleDateFormat.format(currentDate);

        orderDao.saveOrder(new Order("1234567896",SimpleDateFormat.format(currentDate),new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrderForPage() {
        List list = orderDao.queryOrders();
        System.out.println(list);


    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("1234567896",1);
    }

    @Test
    public void queryOrderByUserId() {
        List list = orderDao.queryOrderByUserId(1);
        System.out.println(list);
    }
}