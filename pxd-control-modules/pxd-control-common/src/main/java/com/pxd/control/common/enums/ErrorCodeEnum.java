package com.pxd.control.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    SUCCESS(0,"成功"),
    FAIL(1,"失败"),

    ;

    private int code;

    private String desc;
}
