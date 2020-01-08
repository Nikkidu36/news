package com.fiften.news.service;

import com.fiften.news.util.Result;

public interface NewsDetailService {
    Result searchNewsByTitle(String title);
}
