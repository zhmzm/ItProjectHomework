package com.shop.demo.service;

import com.shop.demo.entity.User;

import java.util.List;

public interface userService {
    List<User> checkAllUser();
    int delUser(int userId);
    int updateUserInfo(User updateUser);
    User checkUserInfo(int userId);

}
