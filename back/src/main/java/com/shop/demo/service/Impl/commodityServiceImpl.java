package com.shop.demo.service.Impl;

import com.shop.demo.Dao.CommodityDao;
import com.shop.demo.Dao.UserDao;
import com.shop.demo.entity.Commodity;
import com.shop.demo.service.commodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commodityServiceImpl implements commodityService {
    @Autowired
    CommodityDao commodityDao;

    @Override
    public Commodity checkCommodity(Commodity checkCommodity) {
        return commodityDao.selectByPrimaryKey(checkCommodity.getId());
    }

    @Override
    public int addCommodity(Commodity addCommodity) {
        return commodityDao.insertSelective(addCommodity);
    }

    @Override
    public int delCommodity(Commodity delCommodity) {
        return commodityDao.deleteByPrimaryKey(delCommodity.getId());
    }
}
