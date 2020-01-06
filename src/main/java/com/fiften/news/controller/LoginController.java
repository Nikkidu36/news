package com.fiften.news.controller;


import com.fiften.news.dao.UserMapper;
import com.fiften.news.model.User;
import com.fiften.news.service.UserService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    Result login(User user){
        return userService.hasUser(user);
    }
}
