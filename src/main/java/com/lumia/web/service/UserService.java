package com.lumia.web.service;

import com.lumia.web.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    int save(User user);

    List<User> findAll();
}
