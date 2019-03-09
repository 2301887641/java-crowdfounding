package com.crowdfunding.service.impl;

import com.crowdfunding.bean.User;
import com.crowdfunding.dao.UserMapper;
import com.crowdfunding.exception.LoginFailException;
import com.crowdfunding.service.UserService;
import com.crowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author suiguozhen on 19-2-28 下午9:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserLogin(Map map) {
        User user = userMapper.queryUserlogin(map);
        if(user==null){
            throw new LoginFailException("用户名或密码错误");
        }
        return user;
    }

    @Override
    public Page queryPage(Map<String, Object> paramMap) {
        Page page = new Page((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));

        Integer startIndex = page.getStartIndex();
        paramMap.put("startIndex", startIndex);

        List<User> datas = userMapper.queryList(paramMap);

        page.setDatas(datas);

        Integer totalsize = userMapper.queryCount(paramMap);

        page.setTotalsize(totalsize);

        return page;
    }
}
