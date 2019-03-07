package com.crowdfunding.controller;

import com.crowdfunding.bean.User;
import com.crowdfunding.service.UserService;
import com.crowdfunding.util.AjaxResult;
import com.crowdfunding.util.Const;
import com.crowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suiguozhen on 19-2-27 下午7:56
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public Object doLogin(HttpSession session, String loginacct, String userpswd, String type) {
        AjaxResult result = new AjaxResult();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>(16);
            paramMap.put("loginacct", loginacct);
            paramMap.put("userpswd", MD5Util.digest(userpswd));
            paramMap.put("type", type);

            User user = userService.queryUserLogin(paramMap);
            session.setAttribute(Const.LOGIN_USER, user);
            result.setSuccess(true);
            // {"success":true}
        } catch (Exception e) {
            result.setMessage("登录失败!");
            e.printStackTrace();
            result.setSuccess(false);
            // {"success":false,"message":"登录失败!"}
            //throw e ;
        }

        return result;
    }
}
