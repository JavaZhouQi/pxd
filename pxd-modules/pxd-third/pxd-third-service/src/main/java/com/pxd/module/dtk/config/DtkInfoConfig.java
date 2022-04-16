package com.pxd.module.dtk.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "dtk")
public class DtkInfoConfig {

    private String url = "https://openapi.dataoke.com/api";

    private String appKey = "";

    private String appSecret = "";

}
