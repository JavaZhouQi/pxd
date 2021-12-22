package com.pxd.dubbo.user.service.impl;

import com.pxd.dubbo.user.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class SysUserServiceImpl implements SysUserService {

    @Override
    public String findUser(String username) {
        return null;
    }

}
