package com.shop.demo.service.Impl;

import com.shop.demo.Dao.OrderlistDao;
import com.shop.demo.Dao.SellerDao;
import com.shop.demo.entity.Seller;
import com.shop.demo.service.sellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class sellerServiceImpl implements sellerService {
    @Autowired
    SellerDao sellerDao;
    @Override
    public int addSeller(Seller newSeller) {
        sellerDao.insertSelective(newSeller);
        return newSeller.getId();
    }

    @Override
    public int delSeller(int sellerId) {
        return sellerDao.deleteByPrimaryKey(sellerId);
    }

    @Override
    public int updateSeller(Seller updateSeller) {
        return sellerDao.updateByPrimaryKeySelective(updateSeller);
    }

    @Override
    public Seller getSellerById(int sellerId) {
        return sellerDao.selectByPrimaryKey(sellerId);
    }

    @Override
    public List<Seller> getAllSeller() {
        return sellerDao.getAllSeller();
    }
}
