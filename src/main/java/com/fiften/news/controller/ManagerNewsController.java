package com.fiften.news.controller;

import com.fiften.news.service.ManageNewsService;
import com.fiften.news.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerNewsController {

    @Autowired
    ManageNewsService manageNewsService;

    @PostMapping("/getAuditNum")
    Result getAuditNum(){
        return manageNewsService.getAuditNum();
    }

}
