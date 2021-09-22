package com.shop.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Api("对默认端口的跳转，不用看了")
public class swaggerController {
    @RequestMapping("/")
    @ApiOperation("自动跳转")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("redirect:" + "/swagger-ui.html");
        return modelAndView;
    }
}
