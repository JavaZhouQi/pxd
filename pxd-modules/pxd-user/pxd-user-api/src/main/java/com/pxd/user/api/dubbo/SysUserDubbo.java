package com.pxd.user.api.dubbo;

import com.pxd.user.api.dto.SysUserDto;

public interface SysUserDubbo {

    SysUserDto findByUsername(String username);

    void add(SysUserDto sysUserDto);

}
