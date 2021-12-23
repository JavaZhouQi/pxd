package com.pxd.service;

import com.pxd.common.utils.ConvertUtils;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.dto.SysUserDto;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.vo.SysUserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class ControlSysUserService {

    @DubboReference
    SysUserService sysUserService;

    public Result<?> add(SysUserVo sysUserVo) {
        sysUserService.add(ConvertUtils.sourceToTarget(sysUserVo, SysUserDto.class));
        return Result.ok();
    }
}
