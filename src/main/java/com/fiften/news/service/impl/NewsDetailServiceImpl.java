package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Autowired

    @Override
    public NewsDetail doUpload(String title, String key, String detail) {
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setTitle(title);
        newsDetail.setKey(key);
        newsDetail.setDetail(detail);

        newsDetail.setSubmitDate(getCurTime());


        return newsDetail;
    }

    @Override
    public Result getAllMyNews() {
        List<HashMap> newsMap = newsDetailMapper.getAllMyNews();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }


}
