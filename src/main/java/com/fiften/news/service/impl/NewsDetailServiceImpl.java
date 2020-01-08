package com.fiften.news.service.impl;

import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
import com.fiften.news.service.TokenService;
import com.fiften.news.util.CommentUtil;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Autowired
    CommentUtil commentUtil;

    @Autowired
    TokenService tokenService;

    @Override
    public NewsDetail doUpload(String title, String key, String detail) {
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setTitle(title);
        newsDetail.setKey(key);
        newsDetail.setDetail(detail);

        newsDetail.setSubmitDate(commentUtil.getCurTime());


        return newsDetail;
    }

    @Override
    public Result getAllMyNews(HttpServletRequest httpServletRequest) {
        Integer userId = Integer.parseInt(tokenService.getUserId(httpServletRequest));
        List<HashMap> newsMap = newsDetailMapper.getAllMyNews(userId);
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }


}
