package com.fiften.news.controller;

import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/getAllDeleteNewslist")
    public Result getAllDeleteNewslist(){
        return newsManageService.getAllDeleteNewslist();
    }

    @PostMapping("/getAllWaitPublishNewslist")
    public Result getAllWaitPublishNewslist(){
        return newsManageService.getAllWaitPublishNewslist();
    }

    @PostMapping("/getAllWaitRejectNewslist")
    public Result getAllWaitRejectNewslist(){
        return newsManageService.getAllWaitRejectNewslist();
    }

    @PostMapping("/getNewsReportlistByID")
    public Result getNewsReportlistByID(@RequestParam("ID") Integer ID){
        return newsManageService.getNewsReports(ID);
    }

    @GetMapping("/publishNewsByID")
    public String publishNewsByID(@RequestParam("newsId") Integer newsId){
        boolean flag = newsManageService.publishNewsByID(newsId);
//        Boolean flag = false;
        System.out.println(newsId);
        if(flag==true){
            return "<script>alert(\"发布成功\") ;window.location = \"http://localhost:8080/newsManager/publishNewslist.html\"</script>";
        } else {
            return "<script>alert(\"发布失败\") ;window.location = \"http://localhost:8080/newsManager/publishNewslist.html\"</script>";
        }
    }

    @PostMapping("/deleteReportedNews")
    public Result deleteReportedNewsByID(@RequestParam("ID") Integer ID){
        return newsManageService.deleteReportedNewsByID(ID);
    }



}
