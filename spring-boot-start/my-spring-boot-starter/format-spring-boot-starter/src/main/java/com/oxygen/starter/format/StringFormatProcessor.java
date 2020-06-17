package com.oxygen.starter.format;

import java.util.Objects;


/**
 * 字符串方式格式
 * @author oxygen
 * @date 2020/6/16
 **/
public class StringFormatProcessor implements FormatProcessor{


    @Override
    public <T> String format(T obj) {
        return "StringFormatProcessor:"+Objects.toString(obj);
    }
}
