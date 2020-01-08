package com.fiften.news.service;

import com.fiften.news.util.Result;

public interface NewsManageService {
    Result getIndexNewsNum();

    Result getAllAuditNewslist();

    Result getOneNews(Integer ID);

    Result saveAuditResult(String auditResult,Integer ID);

    Result getAllDeleteNewslist();

    Result getAllWaitPublishNewslist();

    Result getAllWaitRejectNewslist();
}
