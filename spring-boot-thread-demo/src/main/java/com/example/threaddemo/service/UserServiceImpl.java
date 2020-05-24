package com.example.threaddemo.service;

import com.example.threaddemo.persistence.User;
import com.example.threaddemo.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 风骚的Mic 老师
 * create-date: 2020/5/16-20:45
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
