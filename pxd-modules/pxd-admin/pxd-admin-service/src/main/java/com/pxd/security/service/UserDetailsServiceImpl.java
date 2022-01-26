package com.pxd.security.service;

import com.pxd.security.token.TokenUser;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @DubboReference
    SysUserDubbo sysUserDubbo;

    @Override
    public TokenUser loadUserByUsername(String username) {
        SysUserDto sysUserDto = sysUserDubbo.findByUsername(username);
        if (sysUserDto == null) {
            throw new RuntimeException("账号不存在");
        } else {
            return createJwtUser(sysUserDto);
        }
    }

    private TokenUser createJwtUser(SysUserDto sysUserDto) {
        TokenUser tokenUser = new TokenUser();
        tokenUser.setId(sysUserDto.getId());
        tokenUser.setUsername(sysUserDto.getUsername());
        tokenUser.setPassword(sysUserDto.getPassword());
        return tokenUser;
    }
}
