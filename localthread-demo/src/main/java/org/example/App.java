package org.example;

/**
 * volatile的可见性
 * @author oxygen
 * @time 20200524
 */
public class App {

    /**
     * volatile 修饰数组时候，对象本身是可见的，数组内部的元素是不可见的
     * 通过生成汇编指令可以看见对象本身是有lock指令的，内部的元素数没有生成lock指令
     */
    private static volatile Object[] object=new Object[10];

    public static void main(String[] args) {
        object[0]=1; //lock
        object=new Object[2];
    }

}
