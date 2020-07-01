package com.springboot.demo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.demo.base.api.UserInfoService;
import com.demo.base.pojo.UserInfoDTO;
import com.demo.base.pojo.UserInfoVO;
import com.springboot.demo.consumer.pojo.UserInfoParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8084/getUserInfo?id=2&name=%E5%96%B5%E5%96%B5&age=15
 * @Description 客户信息控制层
 * @Author lz.wang
 * @Since 1.0
 * @Date 2019/11/19
 */
@RestController
@Slf4j
public class UserInfoController {

    /**
     * 忽略启动校验,dubbo服务调用
     */
    @Reference(version = "1.0.0",group = "oxygen",check = false)
    private UserInfoService userInfoService;


    @RequestMapping("/getUserInfoById")
    public UserInfoVO getUserInfoById(Long id){
        log.info("id={}", id);
        return userInfoService.getUserInfoById(id);
    }

    @RequestMapping("/getUserInfo")
    public UserInfoVO getUserInfo(UserInfoParam userInfoParam){
        log.info("userInfoParam={}", JSON.toJSON(userInfoParam));
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(userInfoParam.getId());
        dto.setName(userInfoParam.getName());
        dto.setAge(userInfoParam.getAge());
        return userInfoService.getUserInfo(dto);
    }

}
