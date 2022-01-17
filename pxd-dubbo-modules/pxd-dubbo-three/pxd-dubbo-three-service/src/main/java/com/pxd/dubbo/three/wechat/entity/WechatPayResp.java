package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatPayResp {

    private String code;

    private String message;

    public boolean isSuccess(){
        return code == null;
    }
}
