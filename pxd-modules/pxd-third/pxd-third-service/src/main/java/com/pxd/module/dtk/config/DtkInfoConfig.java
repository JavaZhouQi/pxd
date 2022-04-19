package com.pxd.module.dtk.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@RefreshScope
@Configuration
public class DtkInfoConfig {

    private String url = "https://openapi.dataoke.com/api";

    private String appKey = "62343df685117";

    private String appSecret = "1be04719eb6b5f8d8a116757d58dc275";

}
