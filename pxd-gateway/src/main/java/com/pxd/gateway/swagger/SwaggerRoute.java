package com.pxd.gateway.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger资源信息
 *
 * @author 皮蛋 javazhouqi@163.com
 */
@Data
@Configuration
@ConfigurationProperties("pxd.swagger")
public class SwaggerRoute {

    private List<SwaggerRouteProperties> routes;

}
