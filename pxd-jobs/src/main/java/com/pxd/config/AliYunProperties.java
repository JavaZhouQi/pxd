package com.pxd.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "ali.yun")
@Component
public class AliYunProperties {

    private String accessKeyId;

    private String accessKeySecret;

}
