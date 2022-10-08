package com.example.springbootlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping(value = "/login")
    public String login() {
        // 跳转到 视图层 login.html
        return "login";
    }

    @GetMapping(value = "/login2")
    @ResponseBody
    public String login2() {
        return "login";
    }
}
