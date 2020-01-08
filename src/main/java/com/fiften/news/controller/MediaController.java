package com.fiften.news.controller;

import com.fiften.news.service.MediaService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dwq
 * @Date 2020/1/8 0:27
 */
@RestController
public class MediaController {


    @Autowired
    MediaService mediaService;

    @PostMapping("/getAllNotAvailableMedia")
    Result getUser() {
        return mediaService.getAllNotAvailableMedia();
    }

    @PostMapping("/getMediaById")
     public Result getMediaById(@RequestParam("mediaId") Integer mediaId){
        return  mediaService.getMediaById(mediaId);
    }

    @PostMapping("/passMediaById")
    public Result passMediaById(@RequestParam("mediaId") Integer mediaId){
        return mediaService.passMediaById(mediaId);
    }

    @PostMapping("/logoutMediaById")
    public Result LogoutMediaById(@RequestParam("mediaId") Integer mediaId){
        return mediaService.passMediaById(mediaId);
    }

    @PostMapping("/sumreportMediaById")
    public Result sumreportMediaById(){
        return mediaService.sumreportMediaByID();
    }




}
