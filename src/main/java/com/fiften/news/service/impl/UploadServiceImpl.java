package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.UploadService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadServiceImpl implements UploadService {
    NewsDetailMapper newsDetailMapper;

    @Override
    public Result doUpload(String title, String key, String detail) {
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setTitle(title);
        newsDetail.setKey(key);
        newsDetail.setDetail(detail);


        return null;
    }
}
