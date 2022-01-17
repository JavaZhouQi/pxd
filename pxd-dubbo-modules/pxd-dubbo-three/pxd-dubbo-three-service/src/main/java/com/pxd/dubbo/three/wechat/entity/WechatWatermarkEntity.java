package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatWatermarkEntity {
    /**
     * 小程序appid
     */
    private String appid;
    /**
     * 用户获取手机号操作的时间戳
     */
    private String timestamp;
}
