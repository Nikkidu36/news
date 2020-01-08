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

    @Override
    public Result getMediaById(Integer mediaId) {
        try {

            return Result.createSuccessResult(mediaMapper.selectByPrimaryKey(mediaId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.createByFailure(e.getMessage());
        }
    }

    @Override
    public Result passMediaById(Integer mediaId) {
        try {
            Media baseMedia = mediaMapper.selectByPrimaryKey(mediaId);
            if (baseMedia != null ){
                baseMedia.setCheckStatus("pass");
                baseMedia.setAvailableStatus("Y");
                mediaMapper.updateByPrimaryKeySelective(baseMedia);
                return Result.createSuccessResult();
            }else {
                return Result.createByFailure("找不到用户");
            }
        }catch (Exception e){
            return Result.createByFailure(e.getMessage());
        }
    }
}
