package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.CollectionMapper;
import com.fiften.news.model.Collection;
import com.fiften.news.model.User;
import com.fiften.news.service.CollectionService;
import com.fiften.news.service.TokenService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    TokenService tokenService;

    @Override
    public Result isCollection(String userName,int nid) {

        Collection baseCollection=collectionMapper.selectCollectionByUsernameAndNid(userName,nid);

        if(baseCollection!=null){
            JSONObject res = new JSONObject();

            res.put("type",1);
            return Result.createSuccessResult(res);
        }else{
            JSONObject res = new JSONObject();
            res.put("uid",baseCollection.getUserId());
            res.put("type",2);
            return Result.createSuccessResult(res);
        }
    }

    @Override
    public Result addCollection(int uid, int nid) {

        Collection collection = new Collection();
        collection.setNewsId(nid);
        collection.setUserId(uid);

        return Result.createSuccessResult(collectionMapper.insertSelective(collection));
    }

    @Override
    public Result getMyCollectionList(HttpServletRequest httpServletRequest) {
        Integer userId = Integer.parseInt(tokenService.getUserId(httpServletRequest));
        List<HashMap> newsMap = collectionMapper.getMyCollectionList(userId);
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }

    @Override
    public Result totalCollection(HttpServletRequest httpServletRequest) {
        Integer userId = Integer.parseInt(tokenService.getUserId(httpServletRequest));
        List<HashMap> newsMap = collectionMapper.totalCollection(userId);
        return Result.createSuccessResult(newsMap.size(),newsMap);
    }

}
