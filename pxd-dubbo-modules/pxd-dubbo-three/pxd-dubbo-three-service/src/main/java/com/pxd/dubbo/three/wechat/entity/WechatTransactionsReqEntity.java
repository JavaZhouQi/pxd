package com.pxd.dubbo.three.wechat.entity;


import lombok.Data;

@Data
public class WechatTransactionsReqEntity {
    /**
     * 由微信生成的应用ID，全局唯一。请求基础下单接口时请注意APPID的应用属性，例如公众号场景下，需使用应用属性为公众号的APPID
     */
    private String appid;
    /**
     * 直连商户的商户号，由微信支付生成并下发。
     */
    private String mchid;

}
