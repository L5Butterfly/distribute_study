package com.oxygen.starter.format;

import com.alibaba.fastjson.JSON;


/**
 * Json的方式实现对象的转换-FASTJson处理
 * @author oxygen
 * @date 2020/6/16
 **/
public class JsonFormatProcessor implements FormatProcessor{
    @Override
    public <T> String format(T obj) {
        return "JsonFormatProcessor:"+ JSON.toJSONString(obj);
    }
}
