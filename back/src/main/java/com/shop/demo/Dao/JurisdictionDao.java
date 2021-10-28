package com.shop.demo.Dao;

import com.shop.demo.entity.Jurisdiction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JurisdictionDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    Jurisdiction selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);

    List<Jurisdiction> selectAll();
}