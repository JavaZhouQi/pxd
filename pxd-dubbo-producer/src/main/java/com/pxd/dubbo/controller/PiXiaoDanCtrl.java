package com.pxd.dubbo.controller;

import com.pxd.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiXiaoDanCtrl {

    @DubboReference
    TestService testService;

    @GetMapping("/pixiaodan/test")
    public String test() {
        return testService.test("test");
    }

}
