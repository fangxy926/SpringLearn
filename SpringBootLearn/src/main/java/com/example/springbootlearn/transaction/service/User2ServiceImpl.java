package com.example.springbootlearn.transaction.service;

import com.example.springbootlearn.transaction.dao.User2Dao;
import com.example.springbootlearn.transaction.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Dao user2Dao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user) {
        user2Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user) {
        user2Dao.insert(user);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User2 user) {
        user2Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNewException(User2 user) {
        user2Dao.insert(user);
        throw new RuntimeException();
    }


    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User2 user) {
        user2Dao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNestedException(User2 user) {
        user2Dao.insert(user);
        throw new RuntimeException();
    }
}
