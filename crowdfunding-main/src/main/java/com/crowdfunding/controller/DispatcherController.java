package com.crowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suiguozhen on 19-2-27 下午7:56
 */
@Controller
public class DispatcherController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String loginacct,String userpswd,String type){
        Map<String,Object> map=new HashMap<>(16);
        map.put("loginacct",loginacct);
        map.put("userpswd",userpswd);
        map.put("type",type);


    }
}
