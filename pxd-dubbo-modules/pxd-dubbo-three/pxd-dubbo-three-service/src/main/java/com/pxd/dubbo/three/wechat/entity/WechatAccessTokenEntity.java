package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatAccessTokenEntity extends WechatErrorEntity {

    private String access_token;

    private long expires_in;

}
