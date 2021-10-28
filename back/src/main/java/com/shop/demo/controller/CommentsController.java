package com.shop.demo.controller;

import com.shop.demo.entity.Comments;
import com.shop.demo.service.commentsService;
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

@Api(value="商品评论接口",tags={"商品评论接口"})
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    commentsService commentsService;

    @ApiOperation("新增评论")
    @PostMapping("/add")
    public int addNewComment(Comments newComments){
        Date date = new Date();
        newComments.setTime(date);
        return commentsService.addNewComment(newComments);
    }

    @ApiOperation("查看一个商品下所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name="commodityId",value="商品id"),
    })
    @PostMapping("/checkByCommodity")
    public List<Comments> checkByCommodity(int commodityId){
        return commentsService.checkCommentsByCommodityId(commodityId);
    }

    @ApiOperation("查看一个用户下所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="用户id"),
    })
    @PostMapping("/checkByUser")
    public List<Comments> checkByUser(int userId){
        return commentsService.checkCommentsByCommodityId(userId);
    }
    @ApiOperation("删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="用户id",required=true),
            @ApiImplicitParam(name="commodityId",value="商品id",required=true),
    })
    @PostMapping("/delComment")
    public int delComments(Comments delComment){
        return commentsService.delComment(delComment);
    }
}
