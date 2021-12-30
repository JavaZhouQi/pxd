package com.pxd.dubbo.user.service;

import com.pxd.dubbo.user.dto.SysUserDto;

public interface SysUserService {

    void add(SysUserDto sourceToTarget);

    SysUserDto findByUsername(String username);

}
