package com.fiften.news.service;

import com.fiften.news.model.Media;
import com.fiften.news.util.Result;

/**
 * @author 刘佳昇
 * @Date 2020/1/7 19:36
 */

public interface LoginService {
     Result doLogin(String userName,String password);

     Result register(Media media);
}
