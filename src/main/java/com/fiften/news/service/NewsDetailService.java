package com.fiften.news.service;

import com.fiften.news.model.NewsDetail;
import com.fiften.news.util.Result;

public interface NewsDetailService {
    NewsDetail doUpload(String title, String key, String detail);

    Result getAllMyNews();
}
