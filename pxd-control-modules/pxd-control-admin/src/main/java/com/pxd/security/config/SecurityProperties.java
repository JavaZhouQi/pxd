package com.pxd.security.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    /** Request Headers ： Authorization */
    private String header = "Authorization";

    /** 必须使用最少88位的Base64对该令牌进行编码 */
    private String secret = "pxd_secret";

    /** 令牌过期时间 毫 */
    private Long expirationTime = 24 * 60 * 60L;

}
