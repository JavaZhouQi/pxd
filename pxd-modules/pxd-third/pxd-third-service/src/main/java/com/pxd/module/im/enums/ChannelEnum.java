package com.pxd.module.im.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChannelEnum {

    WECHAT_NOTICE("1","微信支付通知"),

    ;
    private String channel;
    private String desc;

}
