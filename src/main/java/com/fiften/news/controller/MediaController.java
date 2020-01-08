package com.fiften.news.controller;

import com.fiften.news.service.MediaService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/getAllReportMedia")
    public Result getAllReportMedia(){
        return mediaService.getAllReportedMedia();
    }

    @GetMapping("/logoutMedia")
    public String logoutMedia(@RequestParam("mediaId") Integer mediaId){
        if (mediaService.logoutMedia(mediaId)){
            return "<script>\n" +
                    "    alert(\"封号成功\");\n" +
                    "    window.location = \"/userManager/useredit.html\"\n" +
                    "</script>";
        }else {
            return "<script>\n" +
                    "    alert(\"封号失败\");\n" +
                    "    window.location = \"/userManager/useredit.html\"\n" +
                    "</script>";
        }

    }





}
