package com.shop.demo.Dao;

import com.shop.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
@Mapper
public interface UserDao {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccountAndPassword(User record);

    User selectByEmailAndPassword(User record);

    User selectByPhoneAndPassword(User record);
}