package com.fiften.news.service;



import com.fiften.news.model.Manager;
import com.fiften.news.model.Media;
import com.fiften.news.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘佳昇
 * @Date 2019/8/14 15:23
 */

public interface TokenService {
    String getUserToken(User user);
    String getManagerToken(Manager manager);
    String getMediaToken(Media media);
    String getUserId(HttpServletRequest httpServletRequest);
    String getTokenByIdAndPassWord(String id,String password);
}
