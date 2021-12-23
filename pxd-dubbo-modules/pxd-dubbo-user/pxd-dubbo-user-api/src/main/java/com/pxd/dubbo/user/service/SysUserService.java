package com.pxd.dubbo.user.service;

import com.pxd.dubbo.user.dto.SysUserDto;

public interface SysUserService {

    String findUser(String username);

    void add(SysUserDto sourceToTarget);

}
