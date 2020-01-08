package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsManageMapper;
import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsManageServiceImpl implements NewsManageService {
    /**
     * clould not autowire
     * Mapper中记得两个注解
     * @Mapper
     * @Repository
     */

    @Autowired
    NewsManageMapper newsManageMapper;

    @Override
    public Result getAuditNum() {
        int auditNum = newsManageMapper.getAuditNum();
        return Result.createSuccessResult(auditNum);
    }

    @Override
    public Result getAllAuditNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllAuditNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }
}
