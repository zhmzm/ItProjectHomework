package com.shop.demo.controller;

import com.shop.demo.entity.Orderlist;
import com.shop.demo.service.orderService;
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

@Api(value="订单接口",tags={"订单接口"})
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    orderService orderService;

    @ApiOperation(value = "新增订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="用户",required=true),
            @ApiImplicitParam(name="sellerId",value="卖家",required=true),
            @ApiImplicitParam(name="commodityId",value="商品",required=true),
            @ApiImplicitParam(name="num",value="数量",required=true,paramType="int"),
    })
    @PostMapping("/add")
    public int addNewOrder(Orderlist newOrder){
        Date date = new Date();
        newOrder.setTime(date);
        return orderService.addNewOrder(newOrder);
    }

    @ApiOperation(value = "删除订单")
    @PostMapping("/del")
    public int delOrder(int orderId){
        return orderService.delOrder(orderId);
    }

    @ApiOperation(value = "修改订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单号", required = true)
    })
    @PostMapping("/update")
    public int updateOrder(Orderlist updateOrder){
        return orderService.updateOrder(updateOrder);
    }
    @ApiOperation(value = "根据订单号查询订单信息")
    @PostMapping("/getById")
    public Orderlist getOrderById(int orderId){
        return orderService.getOrder(orderId);
    }
    @ApiOperation(value = "根据用户查询订单信息")
    @PostMapping("/getIdByUserId")
    public List<Orderlist> getOrderListByUserId(int UserId){
        return orderService.getOrderByUserId(UserId);
    }
    @ApiOperation(value = "根据卖家id查询订单")
    @PostMapping("/getOrderListBySellerId")
    public List<Orderlist> getOrderListBySellerId(int sellerId){
        return orderService.getOrderBySellerId(sellerId);
    }
}
