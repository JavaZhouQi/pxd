package com.pxd.dubbo.three;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboThreeApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboThreeApp.class, args);
    }

}