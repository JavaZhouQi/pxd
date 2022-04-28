package com.pxd.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("redis")
public class RedisProperties {

    private String host = "192.168.3.9";

    private String post = "6379";

    private String password = "Qiqi1996";

    private int database = 0;

}
