package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://blog.csdn.net/anla_/article/details/79027867
 * 利用Condition实现队列的阻塞等待，唤醒
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/29 7:56
 **/
public class DemoTest {

    //MAX_VALUE(Integer)
    static BlockingQueue<String> blockingQueue= new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        /*blockingQueue.add()->如果队列满了，则报错
                / offer会返回添加元素成功的状态/
                put 阻塞式的添加数据*/
    }
}
