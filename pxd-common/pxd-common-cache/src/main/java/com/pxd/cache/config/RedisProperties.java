package com.pxd.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("redis")
public class RedisProperties {

    private String host = "127.0.0.1";

    private String post = "6379";

    private String password;

    private int database = 0;

}
