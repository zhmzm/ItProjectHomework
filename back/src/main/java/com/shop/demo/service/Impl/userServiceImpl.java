package com.shop.demo.service.Impl;

import com.shop.demo.Dao.UserDao;
import com.shop.demo.entity.User;
import com.shop.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServiceImpl implements userService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> checkAllUser() {
        return userDao.checkAllUserInfo();
    }

    @Override
    public int delUser(int userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(User updateUser) {
        return userDao.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public User checkUserInfo(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
