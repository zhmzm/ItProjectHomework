package com.shop.demo.Dao;

import com.shop.demo.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}