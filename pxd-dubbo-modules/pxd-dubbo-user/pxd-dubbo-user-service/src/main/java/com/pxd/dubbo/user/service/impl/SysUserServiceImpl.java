package com.pxd.dubbo.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pxd.common.constant.Whether;
import com.pxd.common.utils.ConvertUtils;
import com.pxd.dubbo.user.dto.SysUserDto;
import com.pxd.dubbo.user.entity.SysUser;
import com.pxd.dubbo.user.manager.SysUserManager;
import com.pxd.dubbo.user.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@DubboService
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserManager sysUserManager;

    @Override
    public void add(SysUserDto sysUserDto) {
        SysUser sysUser = ConvertUtils.sourceToTarget(sysUserDto, SysUser.class);
        sysUser.setStatus(Whether.YES.getCode());
        LocalDateTime now = LocalDateTime.now();
        sysUser.setCreateTime(now);
        sysUser.setUpdateTime(now);
        sysUserManager.save(sysUser);
    }

    @Override
    public SysUserDto findByUsername(String username) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserManager.getOne(lambdaQueryWrapper);
        if (sysUser == null) {
            return null;
        }
        return ConvertUtils.sourceToTarget(sysUser, SysUserDto.class);
    }
}
