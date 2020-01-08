package com.fiften.news.controller;

import com.fiften.news.service.MediaService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘佳昇
 * @Date 2020/1/8 0:27
 */
@RestController
public class MediaController {


    @Autowired
    MediaService mediaService;

    @PostMapping("/getAllNotAvailableMedia")
    Result getUser(){

        return mediaService.getAllNotAvailableMedia();
    }
}
