package com.shop.demo.Dao;

import com.shop.demo.entity.Seller;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    List<Seller> getAllSeller();
}