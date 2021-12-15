package com.pxd.admin.controller;

import com.pxd.dubbo.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录相关接口")
@RestController
public class LoginController {

    @DubboReference
    SysUserService sysUserService;

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    public String login(){
        return sysUserService.findUser("username");
    }

}
