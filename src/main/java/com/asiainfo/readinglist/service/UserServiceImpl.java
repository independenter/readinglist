package com.asiainfo.readinglist.service;

import com.asiainfo.readinglist.dao.UserDao;
import com.asiainfo.readinglist.entiy.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(cacheNames = "authority", key = "#username")
    @Override
    public SysUser getUserByName(String username) {
        return userDao.selectByName(username);
    }
}