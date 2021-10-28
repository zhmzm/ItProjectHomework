package com.shop.demo.Dao;

import com.shop.demo.entity.Comments;
import com.shop.demo.entity.CommentsKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsDao {
    int deleteByPrimaryKey(CommentsKey key);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(CommentsKey key);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

    List<Comments> checkCommentsByCommodityId(int id);

    List<Comments> checkCommentsByUserId(int id);
}