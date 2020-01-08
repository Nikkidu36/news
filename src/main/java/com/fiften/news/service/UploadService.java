package com.fiften.news.service;

import com.fiften.news.util.Result;

public interface UploadService {
    Result doUpload(String title,String key,String detail);
}
