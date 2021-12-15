package com.pxd.dubbo.three.im.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 腾讯im配置信息
 */
@Setter
@Getter
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "tencent.im")
public class TencentImConfig {

    /*** 请求域名 */
    private String url;

    /*** 应用 SDKAppID，可在即时通信 IM 控制台 的应用卡片中获取。 */
    private Long sdkappid;

    /***  超级管理员用户 ID，旧称为 Identifier。*/
    private String administratorUserId;

    /*** 密钥信息，可在即时通信 IM 控制台 的应用详情页面中获取，具体操作请参见 获取密钥。 */
    private String key;

    /*** UserSig 的有效期，单位为秒。 默认24小时*/
    private long expire = 86400;

}
