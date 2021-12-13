package com.lumia.web.entity;

import java.io.IOException;

public class RmiTest {

    static {
        Runtime runtime = Runtime.getRuntime();
        try {
//            runtime.exec("cmd /c start calc");
            runtime.exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("打印测试");
    }
}
