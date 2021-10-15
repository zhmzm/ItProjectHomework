package com.shop.demo.controller;


import com.shop.demo.entity.User;

import com.shop.demo.service.loginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Api(value="登录界面接口",tags={"登录界面接口"})
@RestController
@RequestMapping("/user")
public class loginController {
    @Autowired
    loginService Servicer;

    @ApiOperation(value = "添加用户", notes = "无返回值")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="昵称",required=true),
            @ApiImplicitParam(name="account",value="账号",required=true),
            @ApiImplicitParam(name="phone_number",value="手机号",required=true),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="string"),
    })
    @PostMapping(value = "/add")
    public int addNewUser(User newUser){
        return Servicer.addNewUser(newUser);
    }

    @ApiOperation("查询用户")
    @PostMapping("/check")
    @ApiImplicitParams({
            @ApiImplicitParam(name="account",value="账号",required=true),
            @ApiImplicitParam(name="password",value="密码",required=true),
    })
    public int checkUser(String account, String password) {
        User checkUser = new User();
        checkUser.setAccount(account);
        checkUser.setPassword(password);
        checkUser.seteMail(checkUser.getAccount());
        return Servicer.checkUser(checkUser);
    }
}
