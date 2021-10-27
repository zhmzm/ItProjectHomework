package com.shop.demo.service.Impl;

import com.shop.demo.Dao.JurisdictionDao;
import com.shop.demo.entity.Jurisdiction;
import com.shop.demo.service.jurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jurisdictionServiceImpl implements jurisdictionService {
    @Autowired
    JurisdictionDao jurisdictionDao;
    @Override
    public int addNewJurisdiction(Jurisdiction newJurisdiction) {
        return jurisdictionDao.insertSelective(newJurisdiction);
    }

    @Override
    public int delJurisdiction(Jurisdiction delJurisdiction) {
        return jurisdictionDao.deleteByPrimaryKey(delJurisdiction.getUserId());
    }

    @Override
    public Jurisdiction checkJurisdiction(int userId) {
        return jurisdictionDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<Jurisdiction> checkAllJurisdiction() {
        return jurisdictionDao.selectAll();
    }
}
