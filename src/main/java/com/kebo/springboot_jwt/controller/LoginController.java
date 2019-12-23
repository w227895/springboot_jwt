package com.kebo.springboot_jwt.controller;

import com.kebo.springboot_jwt.config.JwtHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author: kb
 * @Date: 2019-12-23 20:22
 */
@RestController
public class LoginController {

    @RequestMapping("/user/login")
    public String login() {

        String jwtToken = JwtHelper.generateToken("123",456);

        return jwtToken;
    }

    @RequestMapping("user/hello")
    public String user(){

        return   "hello";
    }
}
