package com.lumia.web.service.impl;

import com.lumia.web.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void Hello() {
        System.out.println("hello");
    }
}
