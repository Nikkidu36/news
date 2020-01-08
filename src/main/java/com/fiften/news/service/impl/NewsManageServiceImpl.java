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
        HashMap news=newsDetailMapper.getOneNewsByID(ID);
        return Result.createSuccessResult(news);
    }

    @Override
    public Result saveAuditResult(String auditResult,Integer ID){
        boolean yn;
        if(auditResult.equals("通过")){
            newsDetailMapper.updateSubmitDateByID(ID);
            yn= newsManageMapper.savePassAuditResult(ID);
        }else if (auditResult.equals("未通过")){
            yn = newsManageMapper.saveNotAuditResult(ID);
        }else{
            yn=false;
            return Result.createByFailure("审核失败！");
        }
        return Result.createSuccessResult(yn);
    }

    @Override
    public Result getAllDeleteNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllDeleteNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }

    @Override
    public Result getAllWaitPublishNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllWaitPublishNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }

    @Override
    public Result getAllWaitRejectNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllWaitRejectNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }
}
