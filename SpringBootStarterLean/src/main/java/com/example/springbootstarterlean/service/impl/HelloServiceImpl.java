package com.example.springbootstarterlean.service.impl;

import com.example.springbootstarterlean.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    public String sayHello() {
        return "Hello!";
    }
}
