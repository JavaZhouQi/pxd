package com.pxd.service;

import com.pxd.common.utils.ConvertUtils;
import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.dto.SysUserDto;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.security.SecurityUtil;
import com.pxd.security.token.TokenUser;
import com.pxd.vo.LoginUserVo;
import com.pxd.vo.SysUserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


@Service
public class ControlSysUserService {

    @DubboReference
    SysUserService sysUserService;

    public Result<?> add(SysUserVo sysUserVo) {
        SysUserDto sysUserDto = ConvertUtils.sourceToTarget(sysUserVo, SysUserDto.class);
        // 密码编码
        sysUserDto.setPassword(SecurityUtil.encodePassword(sysUserVo.getPassword()));
        sysUserService.add(sysUserDto);
        return Result.ok();
    }

    public Result<LoginUserVo> getUserInfo() {
        TokenUser tokenUser = SecurityUtil.getTokenUser();
        LoginUserVo data = new LoginUserVo();
        data.setUserId(tokenUser.getId());
        return Result.ok(data);
    }
}
