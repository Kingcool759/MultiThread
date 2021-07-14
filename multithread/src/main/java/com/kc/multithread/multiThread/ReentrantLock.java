package com.kc.multithread.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @data on 2021/7/14 3:30 下午
 * @auther KC
 * @describe 可重入锁 【独占锁】
 */
public class ReentrantLock {
//    private static Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private static Lock lock = new java.util.concurrent.locks.ReentrantLock(false);  //设置为true则为公平锁,false则为非公平锁。

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
        new Thread(() -> test(), "线程C").start();
        new Thread(() -> test(), "线程D").start();
    }

    public static void test() {
//        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得了锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
//        }
    }
    //打印结果：
    //线程A获得了锁
    //线程A释放了锁
    //线程B获得了锁
    //线程B释放了锁
}
