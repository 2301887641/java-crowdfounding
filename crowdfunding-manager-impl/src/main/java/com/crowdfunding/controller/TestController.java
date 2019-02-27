package com.crowdfunding.controller;

import com.crowdfunding.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author suiguozhen on 19-2-24 上午11:02
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(){
        String s = testService.queryTest();
        return "success";
    }
}
