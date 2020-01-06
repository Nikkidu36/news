package com.fiften.news.service;

import com.fiften.news.model.User;
import com.fiften.news.util.Result;

public interface UserService {
    Result selectAllUser();

    Result insertUser(User user);

    Result updateUser(User user);
}
