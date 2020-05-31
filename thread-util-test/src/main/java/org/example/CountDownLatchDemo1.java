package org.example;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo1
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 12:05
 **/
public class CountDownLatchDemo1 implements Runnable{

    static CountDownLatch countDownLatch=new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new CountDownLatchDemo1()).start();
        }
        // 执行countDown方法，将计数器变为0，唤醒等待的线程执行
        countDownLatch.countDown(); //1-0
    }
    @Override
    public void run() {
        try {
            countDownLatch.await(); //阻塞线程| 1000个线程阻塞
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
