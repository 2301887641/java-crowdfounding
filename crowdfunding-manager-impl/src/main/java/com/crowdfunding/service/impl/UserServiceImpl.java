package com.crowdfunding.service.impl;

import com.crowdfunding.bean.User;
import com.crowdfunding.dao.UserDao;
import com.crowdfunding.exception.LoginFailException;
import com.crowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author suiguozhen on 19-2-28 下午9:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserLogin(Map map) {
        User user = userDao.queryUserLogin(map);
        if(user==null){
            throw new LoginFailException("用户名或密码错误");
        }
        return user;
    }
}
