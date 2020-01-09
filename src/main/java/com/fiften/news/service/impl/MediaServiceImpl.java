package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.MediaMapper;
import com.fiften.news.dao.ReportListMapper;
import com.fiften.news.model.Media;
import com.fiften.news.service.MediaService;
import com.fiften.news.util.Result;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳昇
 * @Date 2020/1/8 0:29
 */

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MediaMapper mediaMapper;
    @Autowired
    ReportListMapper reportListMapper;

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

    @Override
    @Transactional
    public Result getAllReportedMedia() {

        List<Media> avaliMedias = mediaMapper.selectAllAvailableMedia();
        ArrayList<JSONObject> res = new ArrayList<>();

        for (Media media:avaliMedias) {

            Integer reportNum = reportListMapper.getReportCountByMediaId(media.getMediaId());
            if (reportNum != null){
                if (reportNum>=5){
                    JSONObject resItem = (JSONObject) JSONObject.toJSON(media);
                    resItem.put("reportNums",reportNum);
                    resItem.put("reportReason",reportListMapper.getReportByMediaId(media.getMediaId()).get(0).getReason());
                    res.add(resItem);
                }
            }
        }
        return Result.createSuccessResult(res.size(),res);
    }

    @Override
    public boolean logoutMedia(Integer media) {
        try {

            Media baseMedia = mediaMapper.selectByPrimaryKey(media);

            if (baseMedia!=null) {
                baseMedia.setAvailableStatus("N");
                if (mediaMapper.updateByPrimaryKeySelective(baseMedia)>0){
                    return true;
                }else {
                    return false;
                }

            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
