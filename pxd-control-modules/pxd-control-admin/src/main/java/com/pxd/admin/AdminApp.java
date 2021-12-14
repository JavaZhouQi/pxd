package com.pxd.admin;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableDubbo
@SpringBootApplication
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

}
