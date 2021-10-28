package com.shop.demo.Dao;

import com.shop.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(int id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccountAndPassword(User record);

    User selectByEmailAndPassword(User record);

    User selectByPhoneAndPassword(User record);

    List<User> checkAllUserInfo();
}