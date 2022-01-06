package com.pxd.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "jwt")
public class SecurityProperties {

    /** Request Headers ： Authorization */
    private String header = "authorization";

    private String secret  = "pixiaodan_jwt_secret";

    /** 令牌过期时间 此处单位/毫秒 */
    private Long tokenValidityInSeconds = 24 * 60 * 60 * 1000L;

    /** 在线用户 key，根据 key 查询 redis 中在线用户的数据 */
    private String onlineKey = "admin:user:online:";

}
