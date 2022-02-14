package com.pxd.controller;

import com.pxd.common.base.result.Result;
import com.pxd.service.SysUserService;
import com.pxd.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "登录相关接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    SysUserService sysUserService;

    @ApiOperation(value = "查询用户信息")
    @GetMapping
    public Result<?> getUserInfo() {
        return sysUserService.getUserInfo();
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Result<?> add(@Valid @RequestBody SysUserVo sysUserVo) {
        return sysUserService.add(sysUserVo);
    }



}
