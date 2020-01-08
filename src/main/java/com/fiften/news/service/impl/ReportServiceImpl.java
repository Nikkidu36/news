package com.fiften.news.service.impl;

import com.fiften.news.dao.ReportListMapper;
import com.fiften.news.model.ReportList;
import com.fiften.news.service.ReportService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportListMapper reportListMapper;


    @Override
    public Result doReport(int  media_id,int  news_id,String reason){
        ReportList reportList = new ReportList();
        reportList.setMediaId(media_id);
        reportList.setNewsId(news_id);
        reportList.setReason(reason);


        return null;
    }

}
