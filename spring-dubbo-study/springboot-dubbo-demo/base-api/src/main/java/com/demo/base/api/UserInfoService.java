package com.demo.base.api;

import com.demo.base.pojo.UserInfoDTO;
import com.demo.base.pojo.UserInfoVO;


/**
 * 对外暴露的调用接口
 * @author oxygen
 * @date 2020/6/29
 **/
public interface UserInfoService {

    /**
     * getUserInfo
     * @param dto
     * @return
     */
    UserInfoVO getUserInfo(UserInfoDTO dto);


    /**
     * getUserInfoById
     * @param id
     * @return
     */
    UserInfoVO getUserInfoById(Long id);
}
