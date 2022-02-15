package com.pxd.controller;

import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.security.SecurityUtil;
import com.pxd.user.api.dto.*;
import com.pxd.user.api.dubbo.SysRouteDubbo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "路由管理")
@RestController
@RequestMapping("/sys/route")
public class SysRouteController {

    @DubboReference
    SysRouteDubbo sysRouteDubbo;

    @ApiOperation(value = "查询用户路由信息")
    @GetMapping("user")
    public Result<List<SysRouteDto>> getUserRouteInfo() {
        return sysRouteDubbo.findByUserId(SecurityUtil.getUserId());
    }

    @ApiOperation(value = "关联用户路由")
    @GetMapping("set")
    public Result<?> set(@Valid @RequestBody SysRouteUserSetDto sysRouteUserSetDto) {
        return sysRouteDubbo.set(sysRouteUserSetDto);
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result<?> add(@Valid @RequestBody SysRouteAddDto sysRouteAddDto) {
        return sysRouteDubbo.add(sysRouteAddDto);
    }

    @ApiOperation(value = "修改")
    @PutMapping
    public Result<?> update(@Valid @RequestBody SysRouteUpdateDto sysRouteUpdateDto) {
        return sysRouteDubbo.update(sysRouteUpdateDto);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Result<?> del(@PathVariable Long id) {
        return sysRouteDubbo.del(id);
    }

    @ApiOperation(value = "分页")
    @PostMapping("page")
    public Result<PageData<SysRouteDto>> page(@Valid @RequestBody SysRoutePageDto sysRoutePageDto) {
        return sysRouteDubbo.page(sysRoutePageDto);
    }


}
