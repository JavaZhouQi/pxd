package com.pxd.service;

import com.pxd.common.base.result.Result;
import com.pxd.common.base.utils.ConvertUtils;
import com.pxd.security.SecurityUtil;
import com.pxd.security.token.TokenUser;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import com.pxd.vo.LoginUserVo;
import com.pxd.vo.SysUserVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class ControlSysUserService {

    @DubboReference
    SysUserDubbo sysUserDubbo;

    public Result<?> add(SysUserVo sysUserVo) {
        SysUserDto sysUserDto = ConvertUtils.sourceToTarget(sysUserVo, SysUserDto.class);
        // 密码编码
        sysUserDto.setPassword(SecurityUtil.encodePassword(sysUserVo.getPassword()));
        sysUserDubbo.add(sysUserDto);
        return Result.ok();
    }

    public Result<LoginUserVo> getUserInfo() {
        TokenUser tokenUser = SecurityUtil.getTokenUser();
        LoginUserVo data = new LoginUserVo();
        data.setUserId(tokenUser.getId());
        return Result.ok(data);
    }
}
