package com.pxd.controller;

import com.pxd.common.result.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController("pxd")
public class PxdTestController {

    @ApiOperation(value = "获取验证码")
    @GetMapping("test")
    public Result<?> verification() {
        return Result.ok("SUCCESS");
    }
}
