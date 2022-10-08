package com.example.springbootlearn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfileTestService {
    @Value("${test.profile}")
    private String testProfileValue;

    @Value("${spring.application.name}")
    private String applicationName;

    public String testProfile() {
        return "testProfileValue:" + testProfileValue + "--------- applicationName:" + applicationName;
    }
}
