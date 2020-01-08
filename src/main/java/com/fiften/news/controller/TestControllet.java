package com.fiften.news.controller;

import com.fiften.news.util.FileUploadUtil;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/1/7 13:52
 */

@RestController
public class TestControllet {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @PostMapping("/testTempPath")
    public Result testTempPath(){
        System.out.println(System.getProperty("catalina.home"));
        return Result.createSuccessResult(System.getProperty("catalina.home"));
    }

    @PostMapping("/testFileUpload")
    public Result testFileUpload(@RequestParam("file")MultipartFile file){
        String url = fileUploadUtil.fileUpload(file);
        return Result.createSuccessResult(url);


    }

    @PostMapping("/testJsonPost")
    public Result testJsonPost(@RequestBody HashMap parm){
        System.out.println(parm);
        return Result.createSuccessResult(parm);
    }
    @GetMapping("/testGet")
    public String testGet(@RequestParam("id") Integer id){
        System.out.println(id);
        return "<script>alert(\"发布成功\") ;window.history.go(-1)</script>";
    }

}
