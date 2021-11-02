package com.shop.demo.controller;

import com.shop.demo.entity.Seller;
import com.shop.demo.service.sellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="卖家接口",tags={"卖家接口"})
@RestController
@RequestMapping("/seller")
public class sellerController {
    @Autowired
    sellerService sellerService;

    @ApiOperation(value = "新增商户")
    @PostMapping("/add")
    public int addNewSeller(Seller newSeller){
        return sellerService.addSeller(newSeller);
    }

    @ApiOperation(value = "删除商家")
    @PostMapping("/del")
    public int delSeller(int sellerId){
        return sellerService.delSeller(sellerId);
    }

    @ApiOperation(value = "修改商家信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ID",value = "商家id",required = true)
    })
    @PostMapping("/update")
    public int updateSeller(Seller updateSeller){
        return sellerService.updateSeller(updateSeller);
    }

    @ApiOperation(value = "获取所有商家信息")
    @PostMapping("/getAllSeller")
    public List<Seller> getAllSeller(){
        return sellerService.getAllSeller();
    }

    @ApiOperation(value = "根据商家id获取商家信息")
    @PostMapping("/get")
    @ApiImplicitParam(name = "ID",value = "商家id",required = true)
    public Seller getSeller(int sellerId){
        return sellerService.getSellerById(sellerId);
    }
}
