package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

@Data
public class WechatTransactionsJsapiResp extends WechatPayResp{
    /**
     * 预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepay_id;

}
