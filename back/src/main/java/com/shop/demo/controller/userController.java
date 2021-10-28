package com.shop.demo.controller;

import com.shop.demo.entity.ShoppingCart;
import com.shop.demo.entity.User;
import com.shop.demo.service.userService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用户信息", tags = {"用户信息"})
@RestController
@RequestMapping("/userInfo")
public class userController {
    @Autowired
    userService userService;


    @ApiOperation("注销用户")
    @PostMapping("/del")
    public int delUser(int userId){
        return userService.delUser(userId);
    }

    @ApiOperation("查询单个用户")
    @PostMapping("/checkInfo")
    public User checkUserInfo(int userId){
        return userService.checkUserInfo(userId);
    }

    @ApiOperation("查询全部用户")
    @PostMapping("/checkAll")
    public List<User> checkAllUserInfo(){
        return userService.checkAllUser();
    }
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public int updateUserInfo(User updateUser){
        return userService.updateUserInfo(updateUser);
    }
}
