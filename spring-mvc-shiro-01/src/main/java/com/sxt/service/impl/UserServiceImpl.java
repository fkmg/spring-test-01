package com.sxt.service.impl;

import com.sxt.bean.User;
import com.sxt.mapper.UserMapper;
import com.sxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<String> getUserPermissionsByAccount(String account) {
        return userMapper.getUserPermissionsByAccount(account);
    }

    @Override
    public List<String> getUserRolesByAccount(String account) {
        return userMapper.getUserRolesByAccount(account);
    }

    @Override
    public User getUserByAccount(String account) {
        User user = userMapper.getUserByAccount(account);
        return user;
    }
}
