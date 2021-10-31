package com.shop.demo.Dao;

import com.shop.demo.entity.Orderlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderlistDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderlist record);

    int insertSelective(Orderlist record);

    Orderlist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderlist record);

    int updateByPrimaryKey(Orderlist record);

    List<Orderlist> selectByUserId(int userId);

    List<Orderlist> selectBySellerId(int sellerId);
}