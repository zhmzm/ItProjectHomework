package com.shop.demo.controller;

import com.shop.demo.entity.Jurisdiction;
import com.shop.demo.entity.Seller;
import com.shop.demo.service.jurisdictionService;
import com.shop.demo.service.sellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(value="权限管理界面",tags={"权限管理界面"})
@RestController
@RequestMapping("/jurisdiction")
public class jurisdictionController {
    @Autowired
    jurisdictionService jurisdictionService;

    @Autowired
    sellerService sellerService;

    @ApiOperation("新增权限-自动创建新商家并返回商家id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",required = true),
            @ApiImplicitParam(name = "sellerPower",value = "可选选项"),
            @ApiImplicitParam(name = "administratorPower",value = "可选选项"),
    })
    @PostMapping("/add")
    public int addNewJurisdiction(Jurisdiction newJurisdiction){
        Date date = new Date();
        if (newJurisdiction.getAdministratorPower() != null){
            newJurisdiction.setAdministratorStart(date);
        }
        else {
            newJurisdiction.setSellerStart(date);
            Seller sellerInfo = new Seller();
            sellerInfo.setName("need a name");
            int newSellerId = sellerService.addSeller(sellerInfo);
            newJurisdiction.setSellerPower(newSellerId);
            jurisdictionService.addNewJurisdiction(newJurisdiction);
            return newSellerId;
        }
        return jurisdictionService.addNewJurisdiction(newJurisdiction);
    }

    @ApiOperation("删除权限")
    @ApiImplicitParam(name = "userId",value = "只需要用户id",required = true)
    @PostMapping("/del")
    public int delJurisdiction(Jurisdiction delJurisdiction){
        return jurisdictionService.delJurisdiction(delJurisdiction);
    }
    @ApiOperation("查询权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",required = true),
    })
    @PostMapping("/check")
    public Jurisdiction checkJurisdiction(int userId){
        return jurisdictionService.checkJurisdiction(userId);
    }
    @ApiOperation("查询所有高级权限")
    @PostMapping("/checkAll")
    public List<Jurisdiction> checkJurisdiction(){
        return jurisdictionService.checkAllJurisdiction();
    }
}
