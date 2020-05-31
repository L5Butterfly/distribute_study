package org.example;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 计数器，用于控制阻塞一个线程的调用，知道打调用为0后，唤醒。
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 11:57
 **/
public class CountDownLatchDemo {

    /**
     * CountDownLatch有一个计数器字段，您可以根据需要减少它。然后我们可以用它来阻塞一个调用线程，直到它被计数到零。
     * 如果我们正在进行一些并行处理，我们可以使用与我们想要处理的多个线程相同的计数器值来实例化CountDownLatch，
     * 我们可以在每个线程完成后调用countdown（），保证调用await（）的依赖线程将阻塞，直到工作线程完成。
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        /**
         * 定义一个初始值为3的计数器，每个线程执行计数器对象的countdown方法
         */
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->begin");
            countDownLatch.countDown(); //初始值-1 =3-1=2;
            System.out.println(Thread.currentThread().getName()+"->end");
        },"t1").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->begin");
            countDownLatch.countDown(); //2-1=1;
            System.out.println(Thread.currentThread().getName()+"->end");
        },"t2").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->begin");
            countDownLatch.countDown(); //1-1=1;
            System.out.println(Thread.currentThread().getName()+"->end");
        },"t3").start();
        /**
         * 阻塞Main线程
         */
        countDownLatch.await();
    }
}
