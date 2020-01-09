package com.fiften.news.service;

import com.fiften.news.model.Collection;
import com.fiften.news.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface CollectionService {
    Result isCollection(String userName,int nid);

    Result addCollection(int nid,HttpServletRequest httpServletRequest);

    Result delCollection(int nid,HttpServletRequest httpServletRequest);

    Result getMyCollectionList(HttpServletRequest httpServletRequest);

    Result totalCollection(HttpServletRequest httpServletRequest);
}
