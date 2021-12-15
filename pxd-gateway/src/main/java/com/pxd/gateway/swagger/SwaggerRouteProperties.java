package com.pxd.gateway.swagger;

import lombok.Data;

/**
 * Swagger资源信息
 *
 * @author 皮蛋 javazhouqi@163.com
 */
@Data
public class SwaggerRouteProperties {
    /**
     * 文档名称
     */
    private String name;
    /**
     * 文档地址
     */
    private String location;

}
