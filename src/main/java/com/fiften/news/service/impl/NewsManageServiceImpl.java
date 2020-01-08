package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsManageMapper;
import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsManageServiceImpl implements NewsManageService {
    /**
     * clould not autowire
     * Mapper记得注解
     */

    @Autowired
    NewsManageMapper newsManageMapper;

    @Override
    public Result getAuditNum() {
        int auditNum = newsManageMapper.getAuditNum();
        return Result.createSuccessResult(auditNum);
    }
}
