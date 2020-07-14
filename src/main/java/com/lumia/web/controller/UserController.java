package com.lumia.web.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.lumia.web.config.DynamicDataSource;
import com.lumia.web.entity.User;
import com.lumia.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/save")
    public Map<String, String> save(User user) {
        userService.save(user);
        Map<String, String> result = new HashMap<>();
        result.put("message", "保存成功");
        return result;
    }

    @GetMapping("/findAll")
    public Map<String , List<User>> findAll() {
        Map<String, List<User>> result = new HashMap<>();
        List<User> all = userService.findAll();
        result.put("data", all);
        return result;
    }

    @GetMapping("/findAllByDataSource")
    public Map<String , List<User>> findAllByDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://node2:3306/sndo_copy?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        DynamicDataSource.dataSourcesMap.put("sndo_copy", druidDataSource);
        DynamicDataSource.setDataSource("sndo_copy");
        Map<String, List<User>> result = new HashMap<>();
        List<User> all = userService.findAll();
        result.put("data", all);
        return result;
    }
}
