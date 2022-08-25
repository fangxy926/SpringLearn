package com.example.springbootlearn.transaction.dao;

import com.example.springbootlearn.transaction.entity.User1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User1Dao {
    int deleteByPrimaryKey(Integer id);

    int insert(User1 record);

    int insertSelective(User1 record);

    User1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}