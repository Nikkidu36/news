package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.CollectionMapper;
import com.fiften.news.dao.NewsDetailMapper;
import com.fiften.news.model.NewsDetail;
import com.fiften.news.service.NewsDetailService;
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
    NewsDetailService newsDetailService;

    @Autowired
    NewsDetailMapper newsDetailMapper;

    @Autowired
    CollectionMapper collectionMapper;

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

    @Override
    public Result showNewsById(int id) {

        List<HashMap> NewsDetailList;
        List<HashMap> NewsDetailList1;
        if(collectionMapper.isInCollectionByNid(id)==null){
            NewsDetailList=newsDetailMapper.showNewsByIdWithoutCollect(id);
            return Result.createSuccessResult(NewsDetailList.size(),NewsDetailList);
        }
        NewsDetailList1=newsDetailMapper.showNewsById(id);
        return Result.createSuccessResult(NewsDetailList1.size(),NewsDetailList1);
    }

    @Override
    public Result showNewsListById() {
        List<HashMap> NewsDetailList=newsDetailMapper.showNewsListById();

        return Result.createSuccessResult(NewsDetailList.size(),NewsDetailList);
    }

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
