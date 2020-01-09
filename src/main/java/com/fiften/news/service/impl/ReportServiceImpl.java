package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.dao.ReportListMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.model.ReportList;
import com.fiften.news.service.ReportService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportListMapper reportListMapper;

    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Override
    public Result doReport(int news_id,String reason){
        ReportList reportList = new ReportList();
        reportList.setNewsId(news_id);
        reportList.setReason(reason);

        NewsDetail newsDetail = newsDetailMapper.selectByPrimaryKey(news_id);

        reportList.setMediaId(newsDetail.getMediaId());

        return Result.createSuccessResult(reportListMapper.insertSelective(reportList));


    }

}
