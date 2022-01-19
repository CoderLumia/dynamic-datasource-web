package com.lumia.web.controller;

import jdk.nashorn.internal.codegen.CompilerConstants;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
@RequestMapping("/async")
public class AsyncController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping("/hello")
    public String sayHello() {
        try {
            LOGGER.info(Thread.currentThread().getName() + "进入方法");
            String s = helloService();
            LOGGER.info(Thread.currentThread().getName() + "方法返回");
            return s;
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage(), throwable);
            return null;
        }
    }

    @GetMapping("/asyncHello")
    public Callable<String> asyncSayHello() {
        try {
            LOGGER.info(Thread.currentThread().getName() + "进入方法");
            Callable<String> callable = () -> {
                LOGGER.info(Thread.currentThread().getName() + "进入call方法");
                String say = helloService();
                return say;
            };
            /** 抛错 上面的代码不会执行 */
//            int i = 1 / 0;
            /** 同一条线程返回 */
            LOGGER.info(Thread.currentThread().getName() + "方法返回");
            return callable;
        } catch (Throwable throwable) {
            return () -> "查询失败";
        }
    }

    private String helloService() throws InterruptedException {
        Thread.sleep(5000);
        LOGGER.info(Thread.currentThread().getName() + "耗时任务执行执行完成");
        return "hello";
    }
}
