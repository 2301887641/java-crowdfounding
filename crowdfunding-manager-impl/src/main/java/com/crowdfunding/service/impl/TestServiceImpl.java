package com.crowdfunding.service.impl;

import com.crowdfunding.dao.TestDao;
import com.crowdfunding.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suiguozhen on 19-2-24 上午11:11
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public String queryTest() {
        return testDao.query();
    }
}
