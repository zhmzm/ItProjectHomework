package com.shop.demo.service;

import com.shop.demo.entity.Comments;
import com.shop.demo.entity.Commodity;

import java.util.List;

public interface commentsService {
    int addNewComment(Comments newComment);
    int delComment(Comments delComment);
    List<Comments> checkCommentsByCommodityId(int commodityId);
    List<Comments> checkCommentsByUserId(int userId);
}
