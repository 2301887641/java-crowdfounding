package com.crowdfunding.dao;

import com.crowdfunding.bean.User;

import java.util.Map;

/**
 * @author suiguozhen on 19-2-28 下午9:30
 */
public interface UserDao {
    User queryUserLogin(Map map);
}
