package com.pxd.user.api.dubbo;

import com.pxd.user.api.dto.SysUserDto;

public interface SysUserDubbo {

    void add(SysUserDto sysUserDto);

    SysUserDto findByUsername(String username);

}
