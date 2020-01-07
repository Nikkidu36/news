package com.fiften.news.service.impl;

import com.fiften.news.dao.UserMapper;
import com.fiften.news.model.User;
import com.fiften.news.service.UserService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public Result selectAllUser() {

        List<User> users = userMapper.selectAllUser();
        if (users.size()<1){
            return Result.createByFailure("用户太少了");
        }

        return Result.createSuccessResult(users.size(),users);
    }

    @Override
    public Result insertUser(User user) {
        try {

            int col = userMapper.insert(user);
            if (col>0){
                System.out.println("插入成功");
                //col大于1 则表示成功 影响了1行
                return Result.createSuccessResult();
            }else {
                return Result.createByFailure();
            }
        }catch (Exception e){
            return Result.createByFailure(e.getMessage());
        }
    }

    @Override
    public Result updateUser(User user) {
        try {

            if (userMapper.updateByPrimaryKey(user)>0){

                return Result.createSuccessResult();
            }else {
                return Result.createByFailure();
            }
        }catch (Exception e){
            return Result.createByFailure(e.getMessage());
        }
    }

    @Override
    public Result hasUser(User user) {
        User baseUser = userMapper.selectUserByUserNameAndPassword(user);
        if (baseUser!=null){
            return Result.createSuccessResult(user);
        }else {
            return Result.createByFailure("用户名或者密码错误");
        }
    }

    @Override
    public User findUserById(int parseInt) {
        return userMapper.selectByPrimaryKey(parseInt);
    }
}
