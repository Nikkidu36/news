package com.fiften.news.controller;



import com.fiften.news.model.User;
import com.fiften.news.service.LoginService;
import com.fiften.news.service.UserService;
import com.fiften.news.util.MailUtil;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;


    @PostMapping("/login")
    Result login(@RequestParam("userName") String userName,@RequestParam("password") String password){
//        return userService.hasUser(user);
        return loginService.doLogin(userName,password);
    }

    @PostMapping("/sentEmailCode")
    Result sentEmailCode(@RequestParam("email") String email){
        try {

            MailUtil.sendEmail(email);
            return Result.createSuccessResult();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createByFailure(e.getMessage());
        }


    }
}
