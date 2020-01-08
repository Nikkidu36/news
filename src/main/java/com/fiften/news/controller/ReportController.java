package com.fiften.news.controller;

import com.fiften.news.model.ReportList;
import com.fiften.news.service.ReportService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/ReportNews")
    public Result ReportNews(ReportList reportList){
        return reportService.doReport(reportList.getNewsId(), reportList.getReason());
    }

}
