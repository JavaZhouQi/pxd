package com.pxd.user.api.dubbo;

import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.user.api.dto.SysUserAddDto;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dto.SysUserPageDto;
import com.pxd.user.api.dto.SysUserUpdateDto;

public interface SysUserDubbo {

   Result<SysUserDto> findById(Long userId);

   Result<?> add(SysUserAddDto sysUserAddDto);

   Result<?> update(SysUserUpdateDto sysUserUpdateDto);

   Result<?> del(Long id);

   Result<PageData<SysUserDto>> page(SysUserPageDto sysUserPageDto);

   SysUserDto findByUsername(String username);
}
