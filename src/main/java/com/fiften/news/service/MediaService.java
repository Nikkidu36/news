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

    Result logoutMediaById(Integer mediaId);

    Result sumreportMediaById();

}
