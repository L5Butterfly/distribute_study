package com.oxygen.starter.format;


/**
 * 格式化处理
 * @author oxygen
 * @date 2020/6/16
 **/
public interface FormatProcessor {

    /**
     * 定义一个格式化的方法
     * @param obj
     * @param <T>
     * @return
     */
    <T> String format(T obj);
}
