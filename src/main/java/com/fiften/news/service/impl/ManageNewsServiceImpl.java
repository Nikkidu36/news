package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsManageMapper;
import com.fiften.news.service.ManageNewsService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageNewsServiceImpl implements ManageNewsService {
    /**
     * clould not autowire
     */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    NewsManageMapper newsManageMapper;

    @Override
    public Result getAuditNum() {
        int auditNum = newsManageMapper.getAuditNum();
        return Result.createSuccessResult(auditNum);
    }
}
