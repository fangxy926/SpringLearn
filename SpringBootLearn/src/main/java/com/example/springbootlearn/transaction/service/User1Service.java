package com.example.springbootlearn.transaction.service;

import com.example.springbootlearn.transaction.entity.User1;

public interface User1Service {
    public void addRequired(User1 user);

    public void addRequiresNew(User1 user);

    public void addNested(User1 user);

}
