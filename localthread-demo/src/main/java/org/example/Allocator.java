package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程资源AB相互需要等待会导致死锁的情况发生
 * Allocator控制和申请锁
 *
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/24 19:56
 **/
public class Allocator {

    /**
     * 缓存锁的申请信息记录
     */
    private List<Object> list=new ArrayList<>();

    /**
     * 申请锁资源
     * @param from
     * @param to
     * @return
     */
    synchronized  boolean apply(Object from,Object to){
        if(list.contains(from)||list.contains(to)){
            return false;
        }
        list.add(from);
        list.add(to);
        return true;
    }


    /**
     * 释放锁资源
     * @param from
     * @param to
     */
    synchronized void free(Object from,Object to){
        list.remove(from);
        list.remove(to);
    }


}
