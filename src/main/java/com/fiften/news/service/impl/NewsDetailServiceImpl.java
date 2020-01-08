package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    NewsDetailService newsDetailService;

    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Override
    public Result searchNewsByTitle(String title) {



        NewsDetail baseNewsDetail1= newsDetailMapper.searchNewsByTitle(title);

        if(baseNewsDetail1!=null){
            JSONObject res = new JSONObject();
            res.put("ID",baseNewsDetail1.getId());
            return Result.createSuccessResult(res);
        }

        return Result.createByFailure("找不到新闻");
    }
}
