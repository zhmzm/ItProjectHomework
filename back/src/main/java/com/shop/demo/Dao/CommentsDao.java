package com.shop.demo.Dao;

import com.shop.demo.entity.Comments;
import com.shop.demo.entity.CommentsKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsDao {
    int deleteByPrimaryKey(CommentsKey key);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(CommentsKey key);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}