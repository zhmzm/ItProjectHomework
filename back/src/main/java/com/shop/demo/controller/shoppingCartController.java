package com.shop.demo.controller;

import com.shop.demo.entity.Commodity;
import com.shop.demo.entity.Picture;
import com.shop.demo.entity.ShoppingCart;
import com.shop.demo.service.shoppingCart;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value="购物车接口",tags={"购物车接口"})
@RestController
@RequestMapping("/shopCart")
public class shoppingCartController {
    @Autowired
    shoppingCart shoppingCart;

    @ApiOperation("查看购物车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",required=true),
    })
    @PostMapping("/getCartList")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = ShoppingCart.class),
    })
    public List<ShoppingCart> getCartList(ShoppingCart usr){

        return shoppingCart.getAllCommodityFromCart(usr.getUserId());
    }
    @ApiOperation("添加购物车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",required=true),
            @ApiImplicitParam(name="num",required=true),
            @ApiImplicitParam(name="createPrice",required=true),
            @ApiImplicitParam(name="commodityId",required=true),
    })
    @PostMapping("/addCartList")

    public int addToCartList(ShoppingCart newRecord){
        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println(formatter.format(date));
        newRecord.setCreateDate(date);
        return shoppingCart.insertRecord(newRecord);
    }
    @ApiOperation("删除购物车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="购物车记录的id",required=true),
    })
    @PostMapping("/delCart")
    public int delInCartList(int id){
        return shoppingCart.delRecord(id);
    }
    @ApiOperation("更新购物车库存信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="购物车记录的id",required=true),
            @ApiImplicitParam(name="num",value="更新后的库存",required=true),
    })
    @PostMapping("/updateCart")
    public int updateToCartList(ShoppingCart updateRecord){
        return shoppingCart.updateRecord(updateRecord);
    }
}
