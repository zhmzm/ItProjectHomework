package com.shop.demo.Dao;

import com.shop.demo.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    List<ShoppingCart> selectByUserId(Integer userId);

    int updateNum(ShoppingCart record);
}