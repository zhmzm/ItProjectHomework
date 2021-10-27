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
        return userDao.insertSelective(newUser);
    }

    @Override
    public int checkUser(User checkUser) {
        User temp = null;
        if(userDao.selectByAccountAndPassword(checkUser) != null){
            temp = userDao.selectByAccountAndPassword(checkUser);
        }
        if( userDao.selectByPhoneAndPassword(checkUser) != null){
            temp = userDao.selectByAccountAndPassword(checkUser);
        }
        if(userDao.selectByEmailAndPassword(checkUser) != null){
            temp = userDao.selectByAccountAndPassword(checkUser);
        }
        if (temp == null)
        {
            return 0;
        }
        return temp.getId();
    }
}
