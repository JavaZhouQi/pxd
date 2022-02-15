package com.pxd.dubbo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pxd.common.base.utils.ConvertUtils;
import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.entity.SysUser;
import com.pxd.service.ISysUserService;
import com.pxd.user.api.dto.SysUserAddDto;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dto.SysUserPageDto;
import com.pxd.user.api.dto.SysUserUpdateDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class SysUserDubboImpl implements SysUserDubbo {

    @Resource
    ISysUserService sysUserService;

    @Override
    public Result<SysUserDto> findById(Long userId) {
        return null;
    }

    @Override
    public Result<?> add(SysUserAddDto sysUserAddDto) {
        return null;
    }

    @Override
    public Result<?> update(SysUserUpdateDto sysUserUpdateDto) {
        return null;
    }

    @Override
    public Result<?> del(Long id) {
        return null;
    }

    @Override
    public Result<PageData<SysUserDto>> page(SysUserPageDto sysUserPageDto) {
        return null;
    }

    @Override
    public SysUserDto findByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser == null) {
            return null;
        }
        return ConvertUtils.sourceToTarget(sysUser, SysUserDto.class);
    }
}
