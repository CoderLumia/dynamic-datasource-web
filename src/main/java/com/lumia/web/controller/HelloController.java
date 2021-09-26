package com.lumia.web.controller;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author EDZ
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String index() {
        String reqUrl = "http://localhost:8081/hello/test?test={test}";
        Map<String, String> req = CollUtil.newHashMap();
        req.put("test", "test");
        return restTemplate.getForEntity(reqUrl, String.class, req).getBody();
    }

    @GetMapping("/test")
    public String test(@RequestParam String test) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        return test;
    }
}
