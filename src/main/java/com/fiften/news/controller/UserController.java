package com.fiften.news.controller;

import com.fiften.news.model.User;
import com.fiften.news.service.UserService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/getUser")
//    Result getUser(){

//        return userService.selectAllUser();
//    }

    @PostMapping("/insertUser")
    Result insertUser(User user){
        System.out.println(user.toString());
        return userService.insertUser(user);
    }

    @PostMapping("/updateUser")
    Result updateUser(User user){

        return userService.updateUser(user);
    }
}
