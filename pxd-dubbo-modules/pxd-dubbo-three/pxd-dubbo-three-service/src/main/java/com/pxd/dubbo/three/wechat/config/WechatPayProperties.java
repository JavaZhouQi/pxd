package com.pxd.dubbo.three.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("wechat.pay")
public class WechatPayProperties {
    /**
     * 前置url
     */
    private String url = "https://api.mch.weixin.qq.com";
    /**
     * 商户API
     */
    private String appid = "";
    /**
     * 商户号
     */
    private String mch_id = "";
    /**
     * 商户API证书的证书序列号。
     */
    private String serialNumber = "";

    /**
     * 证书私钥key
     */
    private String privateKey =
            "";
    /**
     * apiV3秘钥
     */
    private String apiV3Key = "";
    /**
     * 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。 公网域名必须为https，如果是走专线接入，使用专线NAT IP或者私有回调域名可使用http
     */
    private String notifyUrl = "";
}
