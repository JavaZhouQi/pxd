package com.pxd.controller;

import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.security.SecurityUtil;
import com.pxd.user.api.dto.SysUserAddDto;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dto.SysUserPageDto;
import com.pxd.user.api.dto.SysUserUpdateDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @DubboReference
    SysUserDubbo sysUserDubbo;

    @ApiOperation(value = "查询用户信息")
    @GetMapping
    public Result<SysUserDto> getUserInfo() {
        return sysUserDubbo.findById(SecurityUtil.getUserId());
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Result<?> add(@Valid @RequestBody SysUserAddDto sysUserAddDto) {
        sysUserAddDto.setPassword(SecurityUtil.encodePassword(sysUserAddDto.getPassword()));
        return sysUserDubbo.add(sysUserAddDto);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping
    public Result<?> update(@Valid @RequestBody SysUserUpdateDto sysUserUpdateDto) {
        return sysUserDubbo.update(sysUserUpdateDto);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("{id}")
    public Result<?> del(@PathVariable Long id) {
        return sysUserDubbo.del(id);
    }

    @ApiOperation(value = "分页")
    @PostMapping("page")
    public Result<PageData<SysUserDto>> page(@RequestBody SysUserPageDto sysUserPageDto) {
        return sysUserDubbo.page(sysUserPageDto);
    }

}
