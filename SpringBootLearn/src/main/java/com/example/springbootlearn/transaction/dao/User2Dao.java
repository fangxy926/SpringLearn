package com.example.springbootlearn.transaction.dao;

import com.example.springbootlearn.transaction.entity.User2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User2Dao {
    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    int insertSelective(User2 record);

    User2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);
}