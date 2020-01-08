package com.fiften.news.service;

import com.fiften.news.model.Collection;
import com.fiften.news.util.Result;

public interface CollectionService {
    Result isCollection(int uid,int nid);
}
