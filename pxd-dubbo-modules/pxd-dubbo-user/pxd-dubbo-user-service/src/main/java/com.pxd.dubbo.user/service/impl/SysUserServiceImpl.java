package com.pxd.dubbo.user.service.impl;

import com.pxd.dubbo.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService
public class SysUserServiceImpl implements SysUserService {

    @Override
    public String findUser(String username) {
        log.info("username:{}", username);
        return "success";
    }
}
