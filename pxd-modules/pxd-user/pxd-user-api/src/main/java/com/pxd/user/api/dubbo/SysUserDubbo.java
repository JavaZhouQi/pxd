package com.pxd.user.api.dubbo;

import com.pxd.user.api.dto.SysUserDto;

public interface SysUserDubbo {

    void add(SysUserDto sourceToTarget);

    SysUserDto findByUsername(String username);

}
