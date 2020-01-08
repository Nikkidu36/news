package com.fiften.news.service;

import com.fiften.news.model.NewsDetail;
import com.fiften.news.util.Result;

public interface NewsDetailService {
    Result searchNewsByTitle(String title);

    Result showNewsById(int id);

    Result showNewsListById(int id);
}
