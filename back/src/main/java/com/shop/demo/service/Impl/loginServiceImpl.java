package com.shop.demo.service.Impl;

import com.shop.demo.Dao.UserDao;
import com.shop.demo.entity.User;
import com.shop.demo.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    UserDao userDao;
    @Override
    public int addNewUser(User newUser) {
        userDao.insertSelective(newUser);
        return 0;
    }
}
