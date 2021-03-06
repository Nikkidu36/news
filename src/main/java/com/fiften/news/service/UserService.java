package com.fiften.news.service;

import com.fiften.news.model.User;
import com.fiften.news.util.Result;

public interface UserService {


    Result insertUser(User user);

    Result updateUser(User user);

    Result hasUser(User user);

    User findUserById(int parseInt);


}
