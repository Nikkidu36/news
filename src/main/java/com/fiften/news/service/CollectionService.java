package com.fiften.news.service;

import com.fiften.news.model.Collection;
import com.fiften.news.util.Result;

import javax.servlet.http.HttpServletRequest;

public interface CollectionService {
    Result isCollection(int uid,int nid);

    Result getMyCollectionList(HttpServletRequest httpServletRequest);

    Result totalCollection(HttpServletRequest httpServletRequest);
}
