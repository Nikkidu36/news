package com.fiften.news.service;

import com.fiften.news.model.NewsDetail;
import com.fiften.news.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface NewsDetailService {
    NewsDetail doUpload(String title, String key, String detail);

    Result getAllMyNews(HttpServletRequest httpServletRequest);

    Result searchNewsByTitle(String title);

    Result showNewsById(int id);

    Result showNewsListById();
}
