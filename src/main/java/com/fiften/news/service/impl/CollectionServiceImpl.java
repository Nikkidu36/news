package com.fiften.news.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fiften.news.dao.CollectionMapper;
import com.fiften.news.model.Collection;
import com.fiften.news.service.CollectionService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public Result isCollection(int uid,int nid) {

        Collection collection=new Collection();
        collection.setUserId(uid);
        collection.setNewsId(nid);

        Collection baseCollection=collectionMapper.selectCollectionByUidAndNid(collection);

        if(baseCollection!=null){
            JSONObject res = new JSONObject();
            res.put("type",1);
            return Result.createSuccessResult(res);
        }else{
            JSONObject res = new JSONObject();
            res.put("type",2);
            return Result.createSuccessResult(res);
        }
    }
}
