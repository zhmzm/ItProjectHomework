package com.shop.demo.Dao;

import com.shop.demo.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PictureDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List<Picture> selectByCommodityId(String id);
}