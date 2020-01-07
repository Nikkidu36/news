package com.fiften.news.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fiften.news.model.Manager;
import com.fiften.news.model.Media;
import com.fiften.news.model.User;
import com.fiften.news.service.TokenService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 刘佳昇
 * @Date 2019/9/10 16:25
 */

@Service
public class TokenServiceImpl implements TokenService {
    /**
     * 根据用户Id和密码生成token
     * @param user
     * @return
     */
//    @Override
//    public String getToken(Users user) {
//        String token = "";
//        token = JWT.create().withAudience(""+user.getUserId()).sign(Algorithm.HMAC256(user.getPassword()));
//        return token;
//    }





    @Override
    public String getUserToken(User user) {
        return getTokenByIdAndPassWord(user.getUserId()+"",user.getPassword());

    }

    @Override
    public String getManagerToken(Manager manager) {
        return getTokenByIdAndPassWord(manager.getManagerId()+"",manager.getPassword());
    }

    @Override
    public String getMediaToken(Media media) {
        return getTokenByIdAndPassWord(media.getMediaId()+"",media.getPassword());
    }

    /**
     * 根据token获取userId
     * @param httpServletRequest
     * @return
     */
    @Override
    public String getUserId(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String Msg = JWT.decode(token).getAudience().get(0);
        String []str =Msg.split("/");
        return str[1];
    }

    @Override
    public String getTokenByIdAndPassWord(String id, String password) {
        String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String Msg = localTime +'/' + id;
        String token = "";
        token = JWT.create().withAudience(Msg).sign(Algorithm.HMAC256(password));
        return token;
    }
}
