package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatPayerEntity {

    /**
     * 用户在直连商户appid下的唯一标识。
     */
    private String openid;

    public static WechatPayerEntity init(String openid) {
        WechatPayerEntity wechatPayerEntity = new WechatPayerEntity();
        wechatPayerEntity.setOpenid(openid);
        return wechatPayerEntity;
    }

}
