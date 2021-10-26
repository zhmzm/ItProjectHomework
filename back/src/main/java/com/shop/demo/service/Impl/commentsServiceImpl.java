package com.shop.demo.service.Impl;

import com.shop.demo.Dao.CommentsDao;
import com.shop.demo.entity.Comments;
import com.shop.demo.entity.CommentsKey;
import com.shop.demo.service.commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class commentsServiceImpl implements commentsService {
    @Autowired
    CommentsDao commentsDao;
    @Override
    public int addNewComment(Comments newComment) {
        return commentsDao.insertSelective(newComment);
    }

    @Override
    public int delComment(Comments delComment) {
        CommentsKey tempKey = new CommentsKey();
        tempKey.setCommodityId(delComment.getCommodityId());
        tempKey.setUserId(delComment.getUserId());
        return commentsDao.deleteByPrimaryKey(tempKey);
    }

    @Override
    public List<Comments> checkCommentsByCommodityId(int commodityId) {
        return commentsDao.checkCommentsByCommodityId(commodityId);
    }

    @Override
    public List<Comments> checkCommentsByUserId(int userId) {
        return commentsDao.checkCommentsByUserId(userId);
    }
}
