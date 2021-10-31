package com.shop.demo.service.Impl;

import com.shop.demo.Dao.OrderlistDao;
import com.shop.demo.entity.Orderlist;
import com.shop.demo.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class orderServiceImpl implements orderService {
    @Autowired
    OrderlistDao orderlistDao;
    @Override
    public int addNewOrder(Orderlist newOrder) {
        return orderlistDao.insertSelective(newOrder);
    }

    @Override
    public int delOrder(int orderId) {
        return orderlistDao.deleteByPrimaryKey(orderId);
    }

    @Override
    public int updateOrder(Orderlist updateOrder) {
        return orderlistDao.updateByPrimaryKeySelective(updateOrder);
    }

    @Override
    public List<Orderlist> getOrderByUserId(int userId) {
        return orderlistDao.selectByUserId(userId);
    }

    @Override
    public List<Orderlist> getOrderBySellerId(int sellerId) {
        return orderlistDao.selectBySellerId(sellerId);
    }

    @Override
    public Orderlist getOrder(int orderId) {
        return orderlistDao.selectByPrimaryKey(orderId);
    }
}
