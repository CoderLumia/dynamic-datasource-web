package com.lumia.web.learn;

import java.util.concurrent.atomic.AtomicInteger;

public class MultipulThreadSerialPoint {

    public static AtomicInteger integer = new AtomicInteger(100);

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + ": " + integer.getAndIncrement());
            }, "t" + i).start();
        }

    }
}
