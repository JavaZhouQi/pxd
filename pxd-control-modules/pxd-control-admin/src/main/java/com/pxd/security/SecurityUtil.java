package com.pxd.security;

import com.pxd.security.token.TokenUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    private static PasswordEncoder passwordEncoder;

    public SecurityUtil(PasswordEncoder passwordEncoder) {
        SecurityUtil.passwordEncoder = passwordEncoder;
    }

    /**
     * 获取用户信息
     */
    public static TokenUser getTokenUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new RuntimeException("当前登录状态过期");
        }
        if (authentication.getPrincipal() instanceof TokenUser) {
            return (TokenUser) authentication.getPrincipal();
        }
        throw new RuntimeException("找不到当前登录的信息");
    }

    /**
     * 获取用户id
     */
    public static Long getUserId() {
        return getTokenUser().getId();
    }

    /**
     * 密码编码
     */
    public static String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

}
