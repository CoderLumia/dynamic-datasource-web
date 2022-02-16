package com.lumia.web.learn;

import cn.hutool.core.thread.ThreadUtil;

import java.util.stream.Stream;

public class WaitTest {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Stream.of("线程1", "线程2").forEach(n -> {
            new Thread(() -> {
                waitTest();
            }, n).start();
        });
        ThreadUtil.sleep(5_000);
        notifyAllTest();
    }


    /**
     * wait会将锁释放
     */
    public static void waitTest() {
        synchronized (lock) {
            try {
                System.out.println("进入wait==============>");
                lock.wait();
                System.out.println("唤醒线程" + Thread.currentThread().getName());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    /**
     * 随机唤醒一个线程
     * */
    public static void notifyTest() {
        synchronized (lock) {
            try {
                System.out.println("唤醒wait===========>");
                lock.notify();
                System.out.println("完成唤醒===========>");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void notifyAllTest() {
        synchronized (lock) {
            try {
                System.out.println("唤醒wait===========>");
                lock.notifyAll();
                System.out.println("唤醒全部===========>");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
