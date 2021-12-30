package com.pxd.control.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    VERIFICATION_EXPIRED(2, "验证码过期，请重新获取验证码"),
    VERIFICATION_FAIL(3, "验证码错误"),

    /*** 用户相关错误信息 */
    USER_USERNAME_NOT_NULL(1001, "账号不存在"),
    USER_PASSWORD_FAIL(1002, "密码错误"),

    ;

    private int code;

    private String desc;
}
