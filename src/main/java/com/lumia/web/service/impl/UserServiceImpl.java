package com.lumia.web.service.impl;

import com.lumia.web.entity.User;
import com.lumia.web.mapper.UserMapper;
import com.lumia.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
