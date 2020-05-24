package org.example;

/**
 * HashDemo
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/24 20:00
 **/
public class HashDemo {

    /**
     * ThreadLocal 和神奇的数字 0x61c88647
     * 解决hash碰撞冲突的思想
     */
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        magicHash(16);
        magicHash(32);
    }

    private  static void magicHash(int size){
        int hashCode=0;
        for(int i=0;i<size;i++){
            hashCode=i*HASH_INCREMENT+HASH_INCREMENT;
            System.out.print((hashCode&(size-1))+"  ");
        }
        System.out.println("");
    }

}
