package com.shop.demo.controller;

import com.shop.demo.entity.Commodity;
import com.shop.demo.entity.Picture;
import com.shop.demo.service.commodityService;
import com.shop.demo.service.photoService;
import com.shop.demo.service.loginService;
import io.swagger.annotations.*;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",required=true),
    })
    @PostMapping("/check")
    public Commodity checkCommodity(Commodity commodity){
        return commodityservice.checkCommodity(commodity);
    }
    @ApiOperation("查看商品信息带图片-地址在description")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",required=true),
    })
    @PostMapping("/check2")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = Commodity.class),
    })
    public Commodity checkCommodity2(Commodity commodity){
        commodity = commodityservice.checkCommodity(commodity);
        List<Picture> tempList =  photoService.getPicture(commodity.getId());
        //取商品图片中的第一个查询值返回
        Picture p1=tempList.get(0);
        commodity.setDescription(p1.getAddress());
        return commodity;
    }

    @ApiOperation("添加商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sellerId",required = true)
    })
    @PostMapping("/add")
    public int addCommodity(Commodity commodity){
        return commodityservice.addCommodity(commodity);
    }

    @ApiOperation("删除商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",required=true),
    })
    @PostMapping("/del")
    public int delCommodity(Commodity commodity){
        return commodityservice.delCommodity(commodity);
    }

    @ApiOperation("查看图片")
    @PostMapping("/photo")
    public List<Picture> getPicture(Integer  commodityID){
        return photoService.getPicture(commodityID);
    }
    @ApiOperation("查询商品列表")
    @PostMapping("/shoplist")
    public List<String> getShopList(){
        return commodityservice.getAllCommodity();
    }

}
