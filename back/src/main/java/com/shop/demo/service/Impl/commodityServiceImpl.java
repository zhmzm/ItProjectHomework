package com.shop.demo.service.Impl;

import com.shop.demo.Dao.CommodityDao;
import com.shop.demo.Dao.UserDao;
import com.shop.demo.entity.Commodity;
import com.shop.demo.service.commodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Commodity checkCommodityWithPhoto(Commodity checkCommodity) {
        return null;
    }

    @Override
    public List<String> getAllCommodity() {
        //现在redis里面查
        //查不到再从数据库里面找，然后放到redis里面
        return commodityDao.getAllId();
    }

}
