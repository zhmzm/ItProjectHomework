package com.shop.demo.service;

import com.shop.demo.entity.Orderlist;

import java.util.List;

public interface orderService {
    int addNewOrder(Orderlist newOrder);
    int delOrder(int orderId);
    int updateOrder(Orderlist updateOrder);
    List<Orderlist> getOrderByUserId(int userId);
    List<Orderlist> getOrderBySellerId(int sellerId);
    Orderlist getOrder(int orderId);
}
