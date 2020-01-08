package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.dao.NewsManageMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsManageService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Override
    public Result getIndexNewsNum() {

        JSONObject res = new JSONObject();

        Integer auitNum = newsManageMapper.getAuditNum();
        Integer waitPublishNum = newsManageMapper.getWaitPublishNum();
        Integer waitRejectNum = newsManageMapper.getWaitRejectNum();

        res.put("auitNum",auitNum);
        res.put("waitPublishNum",waitPublishNum);
        res.put("waitRejectNum",waitRejectNum);

        return Result.createSuccessResult(res);
    }

    @Override
    public Result getAllAuditNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllAuditNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }

    @Override
    public Result getOneNews(Integer ID) {
        NewsDetail newsDetail=newsDetailMapper.selectByPrimaryKey(ID);
        return Result.createSuccessResult(newsDetail);
    }
}
