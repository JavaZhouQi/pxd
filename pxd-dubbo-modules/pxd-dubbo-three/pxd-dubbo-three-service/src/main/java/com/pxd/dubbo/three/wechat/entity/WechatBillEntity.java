package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatBillEntity {
    /**
     * 账单日期 (必填)
     * 格式yyyy-MM-dd
     * 仅支持三个月内的账单下载申请。
     */
    private String bill_date;
    /**
     * 账单类型
     * 不填则默认是ALL
     * 枚举值：
     * ALL：返回当日所有订单信息（不含充值退款订单）
     * SUCCESS：返回当日成功支付的订单（不含充值退款订单）
     * REFUND：返回当日退款订单（不含充值退款订单）
     */
    private String bill_type;
    /**
     * 压缩类型
     * 不填则默认是数据流
     * 枚举值：
     * GZIP：返回格式为.gzip的压缩包账单
     */
    private String tar_type;
    /**
     *不填则默认是BASIC
     * 枚举值：
     * BASIC：基本账户
     * OPERATION：运营账户
     * FEES：手续费账户
     */
    private String account_type;
}
