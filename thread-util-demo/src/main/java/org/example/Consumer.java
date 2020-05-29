package org.example;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * Consumer 消费者
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/29 7:54
 **/
public class Consumer implements Runnable{

    //队列
    private Queue<String> msg;

    //队列大小
    private int maxSize;

    //锁（重入锁）
    Lock lock;

    //Condition
    Condition condition;

    /**
     *
     * @param msg
     * @param maxSize
     * @param lock
     * @param condition
     */
    public Consumer(Queue<String> msg, int maxSize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxSize = maxSize;
        this.lock = lock;
        this.condition = condition;
    }


    /**
     * Condition （await和signal使用）
     */
    @Override
    public void run() {
        int i=0;
        while(true){
            i++;
            lock.lock(); //synchronized
            while(msg.isEmpty()){
                System.out.println("消费者队列空了，先等待");
                try {
                    condition.await(); //阻塞线程并释放锁   wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费消息："+msg.remove());
            condition.signal(); //唤醒阻塞状态下的线程
            lock.unlock();
        }
    }
}
