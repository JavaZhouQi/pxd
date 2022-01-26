package com.pxd.module.wechat.entity;

import lombok.Data;

@Data
public class WechatUserPhoneEntity extends WechatErrorEntity {
    /**
     * 用户手机号信息
     */
    private WechatPhoneInfoEntity phone_info;

}
