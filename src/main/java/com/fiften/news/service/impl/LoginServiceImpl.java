package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.ManagerMapper;
import com.fiften.news.dao.MediaMapper;
import com.fiften.news.dao.UserMapper;
import com.fiften.news.model.Manager;
import com.fiften.news.model.Media;
import com.fiften.news.model.User;
import com.fiften.news.service.LoginService;
import com.fiften.news.service.TokenService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘佳昇
 * @Date 2020/1/7 19:37
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MediaMapper mediaMapper;

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    TokenService tokenService;

    @Override
    public Result doLogin(String userName, String password) {

        //0 失败 1user 2media 3manager
        int flag = 0;

        Media media = new Media();
        media.setUserName(userName);
        media.setPassword(password);


        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        Manager manager = new Manager();
        manager.setUserName(userName);
        manager.setPassword(password);


        User baseUser = userMapper.selectUserByUserNameAndPassword(user);
        Media baseMedia = mediaMapper.selectMediaByUserNameAndPassword(media);
        Manager baseManager = managerMapper.selectManagerByUserNameAndPassword(manager);


        if (baseUser!=null){
            flag = 1;
            JSONObject res = new JSONObject();
            res.put("user",baseUser);
            res.put("token",tokenService.getUserToken(baseUser));
            res.put("flag",flag);
            return Result.createSuccessResult(res);
        }else if (baseManager != null){
            JSONObject res = new JSONObject();
            flag = 3;
            res.put("manager",baseManager);
            res.put("token",tokenService.getManagerToken(baseManager));
            res.put("flag",flag);

            return Result.createSuccessResult(res);
        }else if (baseMedia != null){
            flag = 2;

            JSONObject res = new JSONObject();
            res.put("media",baseMedia);
            res.put("token",tokenService.getMediaToken(baseMedia));
            res.put("flag",flag);

            return Result.createSuccessResult(res);
        }

        return Result.createByFailure("找不到用户");
    }
}
