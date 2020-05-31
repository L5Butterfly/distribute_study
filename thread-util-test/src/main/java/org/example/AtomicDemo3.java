package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Atomic原子类操作-线程安全的-底层cas乐观锁控制
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 11:31
 **/
public class AtomicDemo3 {

    public static int i=0;
    public static Lock lock=new ReentrantLock();


    /**
     * 生产者和消费者模式下的控制消费者消费完成进行阻塞，生产者生成完成和进行阻塞挂起
     * Condition的 await() 和signal()方法, 阻塞在condition单项队列和唤醒进行AQS同步队列进行CAS抢占锁
     */
    static Condition trip = lock.newCondition();


    /**
     * countDownLatch 计数器
     */
    static CountDownLatch countDownLatch=new CountDownLatch(2);

    /**
     * 多个线程执行i++操作
     */
    public static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
//        try {
//            trip.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++; //非原子操作
        lock.unlock();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int j = 0; j < 1000; j++) {
            new Thread(()-> AtomicDemo3.incr()).start();
        }
        //trip.signalAll();
        countDownLatch.countDown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+i);
    }
}
