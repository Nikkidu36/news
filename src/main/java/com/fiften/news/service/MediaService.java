package com.fiften.news.service;

import com.fiften.news.util.Result;

/**
 * @author
 * @Date 2020/1/8 0:28
 */

public interface MediaService {
    Result getAllNotAvailableMedia();

    Result getMediaById(Integer mediaId);

    Result passMediaById(Integer mediaId);



    //查看所有被举报超过5次的用户
    Result getAllReportedMedia();


    //注销账号
    boolean logoutMedia(Integer media);

    Result getIdByUserName(String userName);

}
