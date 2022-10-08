package com.example.springbootlearn;

import com.example.springbootlearn.service.ProfileTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ProfileTestService profileTestService;


    @Test
    public void profileTest() {
        System.out.println(profileTestService.testProfile());
    }

}
