package com.pxd.dubbo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService
public class TestServiceImpl implements TestService {

    @Override
    public String test(String param) {
        log.info("test参数:{}", param);
        return "dubbo调用成功";
    }
}
