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

    @PostMapping("/isCollection")
    Result isCollection(@RequestParam("userName") String userName,@RequestParam("newsId") int newsId){
        return collectionService.isCollection(userName,newsId);
    }

    @PostMapping("/addCollection")
    Result addCollection(@RequestParam("news_id") int nid,@RequestParam("user_id") int uid){
        return collectionService.addCollection(uid,nid);
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
