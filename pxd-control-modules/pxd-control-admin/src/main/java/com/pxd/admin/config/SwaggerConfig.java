package com.pxd.admin.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String name;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pxd.admin"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(authToken());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(name + " RestFul API")
                .description("后台管理相关接口文档")
                .version("1.0")
                .build();
    }

    //全站统一参数配置，一般是token。
    private List<ApiKey> authToken() {
        List<ApiKey> arrayList = new ArrayList();
        arrayList.add(new ApiKey("token", "token", "header"));
        return arrayList;
    }
}
