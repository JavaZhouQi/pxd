package com.pxd.module.im.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 查询订单类型
 */
@Getter
@AllArgsConstructor
public enum WechatPayQueryTypeEnum {

    WECHAT_ORDER(1, "根据微信订单号查询"),
    MER_ORDER(2, "根据商户订单号查询");

    private int type;
    private String desc;

}
