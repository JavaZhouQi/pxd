package com.pxd.dubbo.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboUserApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboUserApp.class, args);
    }

}