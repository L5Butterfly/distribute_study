package com.oxygen.springboot.springbootfirst.thirddemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;



/**
 * 实现ImportSelector 接口方式导入bean到Ioc容器
 * CacheImportSelector
 * @author oxygen
 * @date 2020/6/16
 **/
public class CacheImportSelector implements ImportSelector {


    /**
     * 加载配置，通过定制化的选择加载
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //@EnableDefineService注解的信息获取，实现特定加载逻辑
        Map<String,Object> attributes=
                annotationMetadata.getAnnotationAttributes(EnableDefineService.class.getName());
        //动态注入bean :自己去实现判断逻辑实现动态配置
        //返回的是一个固定的CacheService
        System.out.println(attributes);
        return new String[]{CacheService.class.getName()};
        //return new String[]{};
    }
}
