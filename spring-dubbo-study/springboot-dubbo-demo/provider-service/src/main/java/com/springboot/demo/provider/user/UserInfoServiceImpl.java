package com.springboot.demo.provider.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.demo.base.api.UserInfoService;
import com.demo.base.pojo.UserInfoDTO;
import com.demo.base.pojo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;



/**
 * 接口实现
 * @author oxygen
 * @date 2020/6/29
 **/
@Service(version = "1.0.0",group = "oxygen",timeout = 5000)
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    //private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public UserInfoVO getUserInfo(UserInfoDTO dto) {
        UserInfoVO vo = new UserInfoVO();
        vo.setId(dto.getId());
        vo.setAge(dto.getAge());
        vo.setName(dto.getName());
        vo.setAddress("清华大学");
        log.info("json={}", JSON.toJSON(vo));
        return vo;
    }

    @Override
    public UserInfoVO getUserInfoById(Long id) {
        UserInfoVO vo = new UserInfoVO();
        vo.setId(id);
        vo.setAge(20);
        vo.setName("小明");
        vo.setAddress("北京大学");
        log.info("json={}", JSON.toJSON(vo));
        return vo;
    }
}
