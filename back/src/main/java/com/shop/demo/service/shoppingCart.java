package com.shop.demo.service;

import com.shop.demo.entity.ShoppingCart;

import java.util.List;

public interface shoppingCart {
    List<ShoppingCart> getAllCommodityFromCart(Integer UserId);
    int insertRecord(ShoppingCart newRecord);
    int delRecord(int id);
    int updateRecord(ShoppingCart updateRecord);
}
