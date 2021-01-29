package com.lumia.web.learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile只能保证内存的可见性，无法保证原子性
 * synchronized 能保证内存的可见性与原子性
 */
public class TestVolatile {

    private volatile int count = 0;

    private int num = 0;


    public void addCount() {
        count++;
    }

    public synchronized void addNum() {
        num++;
    }

    public int getCount() {
        return count;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(testVolatile::addCount);
        }
        for (int i = 0; i < 1000; i++) {
            executorService.submit(testVolatile::addNum);
        }
        Thread.sleep(8000);
        System.out.println("count:" + testVolatile.getCount());
        System.out.println("num:" + testVolatile.getNum());
    }


}
