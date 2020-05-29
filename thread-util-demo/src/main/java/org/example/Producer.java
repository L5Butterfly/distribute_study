package org.example;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Producer 生产者
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/29 7:55
 **/
public class Producer implements Runnable{

    //队列
    private Queue<String> msg;

    //队列大小
    private int maxSize;

    //锁（重入锁）
    Lock lock;

    //Condition
    Condition condition;


    /**
     * 构造方法
     * @param msg  消息队列
     * @param maxSize  队列大小
     * @param lock  锁（重入锁）
     * @param condition  Condition
     */
    public Producer(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            i++;
            lock.lock();
                while(msg.size()==maxSize){
                    System.out.println("生产者队列满了，先等待");
                    try {
                        condition.await(); //阻塞线程并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产消息："+i);
                msg.add("生产者的消息内容"+i);
                condition.signal(); //唤醒阻塞状态下的线程
            lock.unlock();
        }
    }
}
