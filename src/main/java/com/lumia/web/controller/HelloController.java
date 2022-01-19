package com.lumia.web.controller;

import com.lumia.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author EDZ
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/index")
    private String index() {
        helloService.Hello();
        return "index";
    }

    @GetMapping("/test")
    private String test() throws InterruptedException {
        helloService.Hello();
        return "test";
    }
}
