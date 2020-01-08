package com.fiften.news.controller;

import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class NewsDetailController {
    @Autowired
    NewsDetailService newsDetailService;

    @PostMapping("/getAllMyNews")
    public Result getAllMyNews(){
        return newsDetailService.getAllMyNews();
    }
}
