package com.lumia.web.learn;


/**
 * static 无法保证内存的可见性
 * 疑问  System.out.println语句会使线程去主内存中获取最新值更新到私有线程
 */
public class NoVisibility {

    private static boolean flag = false;

    private  static class ReaderThread extends Thread {
        @Override
        public void run() {
            long i = 0;
            while (!flag) {
                i++;
                new Object();
                System.out.println("hello world");
            }
//            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        flag  = true;
        System.out.println("finished");
    }
}
