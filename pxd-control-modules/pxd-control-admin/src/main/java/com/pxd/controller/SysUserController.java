package com.pxd.controller;

import com.pxd.control.common.result.Result;
import com.pxd.dubbo.user.service.SysUserService;
import com.pxd.service.ControlSysUserService;
import com.pxd.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "登录相关接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    ControlSysUserService controlSysUserService;

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Result<?> add(@RequestBody SysUserVo sysUserVo){
        return controlSysUserService.add(sysUserVo);
    }

}
