package com.pxd.module.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("wechat.mini")
public class WechatMiniProperties {

    /**
     * 设置微信小程序的appid.
     */
    private String appid = "";

    /**
     * 设置微信小程序的Secret.
     */
    private String secret = "";

    /**
     * 设置微信小程序消息服务器配置的token.
     */
    private String token;

    /**
     * 设置微信小程序消息服务器配置的EncodingAESKey.
     */
    private String aesKey;

}
