package com.pxd.common.utils;

import cn.hutool.crypto.SmUtil;

import java.util.Objects;

public class PasswordUtil {

    private static final String hex = "pxd_password";

    /**
     * 对密码进行hax
     * @param password
     * @return
     */
    public static String hax(String password) {
        return SmUtil.sm3(password + hex);
    }

    /**
     * 校验密码是否匹配
     * @param password
     * @param hexPassword
     * @return
     */
    public static boolean verify(String password, String hexPassword) {
        return Objects.equals(hax(password), hexPassword);
    }
}
