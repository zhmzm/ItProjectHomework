package com.shop.demo.service.Impl;

import com.shop.demo.Dao.ShoppingCartDao;
import com.shop.demo.entity.ShoppingCart;
import com.shop.demo.service.shoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class shoppingCartImpl implements shoppingCart {
    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCart> getAllCommodityFromCart(Integer userId) {
        return shoppingCartDao.selectByUserId(userId);
    }

    @Override
    public int insertRecord(ShoppingCart newRecord) {
        return shoppingCartDao.insert(newRecord);
    }

    @Override
    public int delRecord(int id) {
        return shoppingCartDao.deleteByPrimaryKey(id);
    }
}
