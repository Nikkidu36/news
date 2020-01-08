package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsManageMapper;
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

    @Override
    public Result getAuditNum() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Integer auitNum = newsManageMapper.getAuditNum();
        Integer num2 = newsManageMapper.getAuditNum2();
        Integer num3 = newsManageMapper.getAuditNum3();

        nums.add(auitNum);
        nums.add(num2);
        nums.add(num3);

        return Result.createSuccessResult(Result.createSuccessResult(nums));
    }

    @Override
    public Result getAllAuditNewslist() {
        List<HashMap> newsMap = newsManageMapper.getAllAuditNewslist();
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }
}
