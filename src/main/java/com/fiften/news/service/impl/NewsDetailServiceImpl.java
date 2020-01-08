package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    NewsDetailService newsDetailService;

    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Override
    public Result searchNewsByTitle(String title) {

        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setTitle(title);

        return null;
    }
}
