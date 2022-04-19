package com.pxd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlatformEnum {

    TB("tb","淘宝"),
    JD("jd","京东"),
    PDD("pdd","拼多多"),
    ;
    private final String platform;
    private final String desc;

}
