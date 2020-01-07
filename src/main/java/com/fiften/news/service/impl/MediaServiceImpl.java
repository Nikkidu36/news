package com.fiften.news.service.impl;

import com.fiften.news.dao.MediaMapper;
import com.fiften.news.model.Media;
import com.fiften.news.service.MediaService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘佳昇
 * @Date 2020/1/8 0:29
 */

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MediaMapper mediaMapper;


    @Override
    public Result getAllNotAvailableMedia() {
        List<Media> medias = mediaMapper.selectAllNotAvailableMedia();
        return Result.createSuccessResult(medias.size(),medias);
    }
}
