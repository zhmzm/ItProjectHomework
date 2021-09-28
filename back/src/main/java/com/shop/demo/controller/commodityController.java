package com.shop.demo.controller;

import com.shop.demo.entity.Commodity;
import com.shop.demo.entity.Picture;
import com.shop.demo.service.commodityService;
import com.shop.demo.service.photoService;
import com.shop.demo.service.loginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="商品界面接口",tags={"商品界面接口"})
@RestController
@RequestMapping("/commodity")
public class commodityController {
    @Autowired
    commodityService commodityservice;

    @Autowired
    photoService photoService;

    @ApiOperation("查看商品信息")
    @PostMapping("/check")
    public Commodity checkCommodity(Commodity commodity){
        return commodityservice.checkCommodity(commodity);
    }


    @ApiOperation("添加商品信息")
    @PostMapping("/add")
    public int addCommodity(Commodity commodity){
        return commodityservice.addCommodity(commodity);
    }

    @ApiOperation("删除商品信息")
    @PostMapping("/del")
    public int delCommodity(Commodity commodity){
        return commodityservice.delCommodity(commodity);
    }

    @ApiOperation("查看图片")
    @PostMapping("/photo")
    public List<Picture> getPicture(String  commodityID){
        return photoService.getPicture(commodityID);
    }

}
