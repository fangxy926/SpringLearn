package com.example.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnnotationTest {


    @Bean
    public Object func() {
        return new Object();
    }
}
