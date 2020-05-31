package org.example;

import java.util.concurrent.atomic.AtomicInteger;



/**
 * Atomic原子类操作-线程安全的-底层cas乐观锁控制
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 11:31
 **/
public class AtomicDemo {

//    public static int i=0;
    public static AtomicInteger i= new AtomicInteger(0);
    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        i++; //
        i.getAndIncrement();
    }
    public static void main(String[] args) {
        for (int j = 0; j < 1000; j++) {
            new Thread(()->AtomicDemo.incr()).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:"+i.get());
    }
}
