package com.crowdfunding.service;

import com.crowdfunding.bean.User;
import com.crowdfunding.util.Page;

import java.util.Map;

/**
 * @author suiguozhen on 19-2-28 下午9:29
 */
public interface UserService {
    //查询用户登录
    User queryUserLogin(Map map);
    Page queryPage(Map<String,Object> paramMap);
}
