package com.lumia.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


/**
 * SSE(Server Sent Event)
 * 服务端往前端单向传输数据
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class SSEController {


    /**
     * 返回类型必须是：text/event-stream;charset=UTF-8
     * @return
     */
    @RequestMapping(value = "/getData", produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String push() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000L);
        } catch (Throwable throwable) {

        }
        int value = (int) (Math.random() * 1000);
        return "event:notice\ndata: {value: " + value + "}\nretry:"+ 5000 + "\n\n";
    }
}
