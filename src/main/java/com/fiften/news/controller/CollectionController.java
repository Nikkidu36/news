package com.fiften.news.controller;

import com.fiften.news.service.CollectionService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @PostMapping("/collection")
    Result collection(@RequestParam("userId") int userId,@RequestParam("newsId") int newsId){
        return collectionService.isCollection(userId,newsId);
    }

    @PostMapping("/getMyCollectionList")
    Result getMyCollectionList(HttpServletRequest httpRequest){
        return collectionService.getMyCollectionList(httpRequest);
    }

    @PostMapping("/totalCollection")
    Result totalCollection(HttpServletRequest httpRequest){
        return collectionService.totalCollection(httpRequest);
    }
}
