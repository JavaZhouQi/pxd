package com.pxd;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ThirdApp {

    public static void main(String[] args) {
        SpringApplication.run(ThirdApp.class, args);
    }

}
