package com.lumia.web.learn;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ThreadPoolExecutor;


public class ThreadUtilTest {

    public static void main(String[] args) {
        ThreadUtil.execute(() -> {
            System.out.println("execute1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ThreadUtil.execute(() -> {
            System.out.println("execute2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ThreadUtil.execute(() -> {
            System.out.println("execute3");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
