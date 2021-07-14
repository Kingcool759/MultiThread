package com.kc.multithread.keyWords;

/**
 * @data on 2021/7/14 11:45 上午
 * @auther
 * @describe synchronized关键字
 */
public class KCsynchronized {
    private static int count = 1;
//    private volatile static int count = 1;  //非线程安全

    public synchronized static void increase() {  //保证线程安全
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                }
            }).start();
        }
        System.out.println(count);
    }
}
