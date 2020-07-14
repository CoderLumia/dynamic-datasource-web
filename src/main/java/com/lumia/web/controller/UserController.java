package com.lumia.web.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.lumia.web.annotation.SystemLog;
import com.lumia.web.config.DynamicDataSource;
import com.lumia.web.entity.User;
import com.lumia.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @SystemLog(type = "findALL", desc = "查询所有用户", module = "User")
    public Map<String , List<User>> findAll() {
        Map<String, List<User>> result = new HashMap<>();
        List<User> all = userService.findAll();
        result.put("data", all);
        return result;
    }

    @GetMapping("/findAllByDataSource/{service}")
    public Map<String , List<User>> findAllByDataSource(@PathVariable("service") String service) {

        String url = "jdbc:mysql://192.168.0.215:3306/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        if ("sndo".equals(service)) {
            DynamicDataSource.setDataSource("defaultDataSource");
        } else {
            boolean containsKey = DynamicDataSource.dataSourcesMap.containsKey(service);
            if (containsKey) {
                DynamicDataSource.setDataSource(service);
            } else {
                String format = String.format(url, service);
                DruidDataSource druidDataSource = new DruidDataSource();
                druidDataSource.setUrl(format);
                druidDataSource.setUsername("root");
                druidDataSource.setPassword("root");
                DynamicDataSource.dataSourcesMap.put(service, druidDataSource);
                DynamicDataSource.setDataSource(service);
            }
        }

        Map<String, List<User>> result = new HashMap<>();
        List<User> all = userService.findAll();
        result.put("data", all);
        return result;
    }
}
