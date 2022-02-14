package com.pxd.dubbo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pxd.common.base.constant.Whether;
import com.pxd.common.base.utils.ConvertUtils;
import com.pxd.entity.SysUser;
import com.pxd.service.ISysUserService;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@DubboService
public class SysUserDubboImpl implements SysUserDubbo {

    @Resource
    ISysUserService sysUserService;

    @Override
    public SysUserDto findByUsername(String username) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserService.getOne(lambdaQueryWrapper);
        if (sysUser == null) {
            return null;
        }
        return ConvertUtils.sourceToTarget(sysUser, SysUserDto.class);
    }

    @Override
    public void add(SysUserDto sysUserDto) {
        SysUser sysUser = ConvertUtils.sourceToTarget(sysUserDto, SysUser.class);
        sysUser.setStatus(Whether.YES.getCode());
        LocalDateTime now = LocalDateTime.now();
        sysUser.setCreateTime(now);
        sysUser.setUpdateTime(now);
        sysUserService.save(sysUser);
    }

}
