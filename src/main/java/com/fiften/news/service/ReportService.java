package com.fiften.news.service;

import com.fiften.news.util.Result;

public interface ReportService {
    Result doReport(int media_id,int news_id,String reason);
}


