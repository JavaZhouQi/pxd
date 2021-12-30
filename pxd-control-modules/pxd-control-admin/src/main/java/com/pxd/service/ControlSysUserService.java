package com.pxd.service;

import com.pxd.common.utils.ConvertUtils;
import com.pxd.common.utils.PasswordUtil;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.dto.SysUserDto;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.vo.LoginUserVo;
import com.pxd.vo.SysUserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ControlSysUserService {
    @Resource
    RedissonClient redissonClient;
    @DubboReference
    SysUserService sysUserService;

    public Result<?> add(SysUserVo sysUserVo) {
        SysUserDto sysUserDto = ConvertUtils.sourceToTarget(sysUserVo, SysUserDto.class);
        sysUserDto.setPassword(PasswordUtil.hax(sysUserVo.getPassword()));
        sysUserService.add(sysUserDto);
        return Result.ok();
    }

    public Result<LoginUserVo> getUserInfo() {

        return null;
    }
}
