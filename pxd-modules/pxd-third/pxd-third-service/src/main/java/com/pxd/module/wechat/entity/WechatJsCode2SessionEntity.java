package com.pxd.module.wechat.entity;

import lombok.Data;

@Data
public class WechatJsCode2SessionEntity extends WechatErrorEntity{

    private String session_key;

    private String openid;

    private String unionid;

}
