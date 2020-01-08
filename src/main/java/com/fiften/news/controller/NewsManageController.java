package com.fiften.news.controller;

import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsManageController {

    @Autowired
    NewsManageService newsManageService;

    @PostMapping("/getIndexNewsNum")
    Result getIndexNum(){
        return newsManageService.getIndexNewsNum();
    }

    @PostMapping("/getAllAuditNewslist")
    public Result getAllAuditNewslist(){
        return newsManageService.getAllAuditNewslist();
    }

    @PostMapping("/getOneNewsByID")
    public Result getOneNews(@RequestParam("ID")Integer ID){
        return newsManageService.getOneNews(ID);
    }

    @PostMapping("/saveAuditResult")
    public Result saveAuditResult(@RequestParam("auditResult") String auditResult,@RequestParam("ID") Integer ID){
        return newsManageService.saveAuditResult(auditResult,ID);
    }

}
