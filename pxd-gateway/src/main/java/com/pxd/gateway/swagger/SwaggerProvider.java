package com.pxd.gateway.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 皮蛋 javazhouqi@163.com
 */
@Primary
@Component
public class SwaggerProvider implements SwaggerResourcesProvider {
    private static final String API_URI = "/v2/api-docs";
    @Autowired
    private SwaggerRoute swaggerRoute;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResourceList = new ArrayList<>();
        swaggerRoute.getRoutes().forEach(route -> swaggerResourceList.add(swaggerResource(route)));
        return swaggerResourceList;
    }

    private SwaggerResource swaggerResource(SwaggerRouteProperties route) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(route.getName());
        swaggerResource.setLocation(route.getLocation().concat(API_URI));
        swaggerResource.setSwaggerVersion("2.x");
        return swaggerResource;
    }

}