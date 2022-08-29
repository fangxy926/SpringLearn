package com.example.springbootlearn.transaction.service;

import com.example.springbootlearn.transaction.dao.User1Dao;
import com.example.springbootlearn.transaction.entity.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User1ServiceImpl implements User1Service {

    @Autowired
    private User1Dao user1Dao;

    @Override
    public void addNoTransaction(User1 user) {
        user1Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user) {
        user1Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User1 user) {
        user1Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User1 user) {
        user1Dao.insert(user);
    }
}
