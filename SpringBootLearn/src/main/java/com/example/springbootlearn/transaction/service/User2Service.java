package com.example.springbootlearn.transaction.service;

import com.example.springbootlearn.transaction.entity.User2;


public interface User2Service {
    public void addRequired(User2 user);
    public void addNoTransaction(User2 user);
    public void addRequiredException(User2 user);
    public void addRequiredException2(User2 user);

    public void addRequiresNew(User2 user);
    public void addRequiresNewException(User2 user);

    public void addNested(User2 user);
    public void addNestedException(User2 user);

}
