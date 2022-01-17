package com.pxd.dubbo.three.wechat.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WechatPayHttpTypeEnum {
    HTTP_GET(1),
    HTTP_POST(2),
    ;
    private int type;

}
