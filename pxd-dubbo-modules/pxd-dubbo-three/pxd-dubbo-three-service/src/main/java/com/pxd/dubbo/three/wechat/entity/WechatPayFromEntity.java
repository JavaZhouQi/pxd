package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatPayFromEntity {
    /**
     * 出资账户类型
     * 下面枚举值多选一。
     * 枚举值：
     * AVAILABLE : 可用余额
     * UNAVAILABLE : 不可用余额
     */
    private String account;
    /**
     * 对应账户出资金额
     */
    private Long amount;
}
