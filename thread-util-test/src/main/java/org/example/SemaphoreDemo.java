package org.example;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo  信号标; 旗语; 获取令牌指令，多线程场景使用
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 12:11
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        /**
         * 初始化一个令牌桶，5个令牌，10个线程进行抢占
         */
        Semaphore semaphore=new Semaphore(5); //令牌数 state=5
        for(int i=0;i<10;i++){
            new Car(semaphore,i).start();
        }
    }

    /**
     * 汽车抢占车位为例子
     */
    static class Car extends Thread{
        Semaphore semaphore;
        int num;

        /**
         * 构造传参
         * @param semaphore
         * @param num
         */
        public Car(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }
        @Override
        public void run() {
            try {
                //获取令牌
                semaphore.acquire(); //5-1 获得令牌.(没拿到令牌，会阻塞，拿到了就可以往下执行）
                System.out.println("第"+num+"线程占用一个令牌");
                Thread.sleep(3000);
                System.out.println("第"+num+"线程释放一个令牌");
                //释放令牌
                semaphore.release(); //释放令牌
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
