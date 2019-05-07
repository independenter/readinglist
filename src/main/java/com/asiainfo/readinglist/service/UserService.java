package com.asiainfo.readinglist.service;

import com.asiainfo.readinglist.entiy.SysUser;

public interface UserService {
    public SysUser getUserByName(String username);
}
