package com.lumia.web.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos/")
public class NacosController {

    /**
     * 读取nacos的配置
     * key为nacos.test  冒号后面为默认值
     */
    @NacosValue(value = "${nacos.test:noValue}", autoRefreshed = true)
    private String value;


    @RequestMapping("/test")
    public String sayHello() {
        return value;
    }
}
