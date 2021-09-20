package com.shop.demo.controller;


import com.shop.demo.entity.User;

import com.shop.demo.service.loginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("登录界面接口")
@RestController
@RequestMapping("/user")
@Controller
public class loginController {
    @Autowired
    loginService Servicer;

    @ApiOperation("添加用户")
    @PostMapping(value = "/user/add")
    public int addNewUser(User newUser){
        return Servicer.addNewUser(newUser);
    }

    @ApiOperation("查询用户")
    @PostMapping("/user/check")
    public int checkUser(User checkUser){
        if (Servicer.checkUser(checkUser) == null){
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
