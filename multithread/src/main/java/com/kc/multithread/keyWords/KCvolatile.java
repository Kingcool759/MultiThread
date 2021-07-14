package com.kc.multithread.keyWords;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @data on 2021/7/14 11:49 上午
 * @auther
 * @describe
 */
public class KCvolatile {
//    private static int count;

    private volatile static int count = 1;  //非线程安全(有非原子操作即i++操作时)，线程安全(单纯赋值操作)

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    count = 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();
        new Thread(()->System.out.println(count),"线程B").start();
        new Thread(()->System.out.println(count),"线程C").start();
    }

    //打印结果：无volatile修饰时：0，0 ；有volatile修饰时：1，1。
}


