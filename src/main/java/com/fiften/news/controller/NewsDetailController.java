package com.fiften.news.controller;

import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsDetailController {

    @Autowired
    NewsDetailService newsDetailService;

    @PostMapping("/search")
    Result searchNewsByTitle(@RequestParam("searchContent") String title){
        return newsDetailService.searchNewsByTitle(title);
    }

    @PostMapping("/showDetail")
    Result showNewsById(@RequestParam("news_id") int id){
        return newsDetailService.showNewsById(id);
    }

    @PostMapping("/showNewsList")
    Result showNewsListById(@RequestParam("news_id") int id){
        return newsDetailService.showNewsListById(id);
    }

}
