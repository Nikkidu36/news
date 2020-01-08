package com.fiften.news.controller;

import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NewsDetailController {
    @Autowired
    NewsDetailService newsDetailService;

    @PostMapping("/getAllMyNews")
    public Result getAllMyNews(HttpServletRequest httpRequest){
        return newsDetailService.getAllMyNews(httpRequest);
    }

    @PostMapping("/UploadNews")
    public NewsDetail UploadNews(String title,String key,String detail){
        return newsDetailService.doUpload(title,key,detail);
    }
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
