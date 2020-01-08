package com.fiften.news.controller;

import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsManageController {

    @Autowired
    NewsManageService newsManageService;

    @PostMapping("/getAuditNum")
    Result getAuditNum(){
        return newsManageService.getAuditNum();
    }

    @PostMapping("/getAllAuditNewslist")
    public Result getAllAuditNewslist(){
        return newsManageService.getAllAuditNewslist();
    }

}
