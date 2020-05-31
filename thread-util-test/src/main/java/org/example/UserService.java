package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列的使用;take和put对元素的获取和添加都会进行阻塞
 *
 * 1. 队列元素已满，进行put添加线程会阻塞
 * 2. 队列数据消费为空，进行take获取元素的队列被阻塞
 *
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 12:15
 **/
public class UserService {

    /**
     * 初始化一个线程池，单线程执行
     */
    private final ExecutorService executorService= Executors.newSingleThreadExecutor();

    /**
     * 带缓存的线程池
     */
    private final ExecutorService cacheExecutor= Executors.newCachedThreadPool();

    /**
     * 初始化一个队列大小为10的队列
     */
    ArrayBlockingQueue<User> arrayBlockingQueue=new ArrayBlockingQueue(10);
    {
        init();
    }
    public void init(){ //不断消费队列的线程
        executorService.execute(()->{
            while(true){
                try {
                    User user=arrayBlockingQueue.take(); //阻塞式
                    System.out.println("发送优惠券给："+user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean register(){
        User user=new User("Mic");
        addUser(user);
        //发送积分.
        try {
            arrayBlockingQueue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
    private void addUser(User user){
        System.out.println("添加用户:"+user);
    }

    public static void main(String[] args) {
        new UserService().register();
    }
}
