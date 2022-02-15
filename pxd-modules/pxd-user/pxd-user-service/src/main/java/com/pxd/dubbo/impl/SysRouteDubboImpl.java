package com.pxd.dubbo.impl;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pxd.common.base.constant.Whether;
import com.pxd.common.base.utils.ConvertUtils;
import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.entity.SysRoute;
import com.pxd.entity.SysUser;
import com.pxd.entity.SysUserRoute;
import com.pxd.service.ISysRouteService;
import com.pxd.service.ISysUserRouteService;
import com.pxd.user.api.dto.*;
import com.pxd.user.api.dubbo.SysRouteDubbo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@DubboService
public class SysRouteDubboImpl implements SysRouteDubbo {

    ISysRouteService iSysRouteService;
    ISysUserRouteService iSysUserRouteService;

    @Override
    public Result<List<SysRouteDto>> findByUserId(Long userId) {
        LambdaQueryWrapper<SysUserRoute> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRoute::getUserId, userId);
        List<SysUserRoute> list = iSysUserRouteService.list(queryWrapper);
        LambdaQueryWrapper<SysRoute> sysRouteLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysRouteLambdaQueryWrapper.in(!CollectionUtils.isEmpty(list), SysRoute::getId, list.stream().map(SysUserRoute::getRouteId).collect(Collectors.toList()));
        List<SysRoute> sysRouteList = iSysRouteService.list(sysRouteLambdaQueryWrapper);
        return Result.ok(ConvertUtils.sourceToTarget(sysRouteList, SysRouteDto.class));
    }

    @Override
    public Result<?> add(SysRouteAddDto sysRouteAddDto) {
        if (!Objects.equals(sysRouteAddDto.getParentId(), 0L) && iSysRouteService.getById(sysRouteAddDto.getParentId()) == null) {
            return Result.error("父级路由不存在");
        }
        SysRoute sysRoute = ConvertUtils.sourceToTarget(sysRouteAddDto, SysRoute.class);
        LocalDateTime now = LocalDateTime.now();
        sysRoute.setCreateTime(now);
        sysRoute.setUpdateTime(now);
        iSysRouteService.save(sysRoute);
        return Result.ok();
    }

    @Override
    public Result<?> update(SysRouteUpdateDto sysRouteUpdateDto) {
        SysRoute sysRouteServiceById = iSysRouteService.getById(sysRouteUpdateDto.getId());
        if (sysRouteServiceById == null) {
            return Result.error("数据不存在");
        }
        if (!Objects.equals(sysRouteUpdateDto.getParentId(), 0L) && iSysRouteService.getById(sysRouteUpdateDto.getParentId()) == null) {
            return Result.error("父级路由不存在");
        }
        BeanUtils.copyProperties(sysRouteUpdateDto, sysRouteServiceById);
        sysRouteServiceById.setUpdateTime(LocalDateTime.now());
        iSysRouteService.updateById(sysRouteServiceById);
        return Result.ok();
    }

    @Override
    public Result<?> del(Long id) {
        return iSysRouteService.removeById(id) ? Result.ok() : Result.error();
    }

    @Override
    public Result<PageData<SysRouteDto>> page(SysRoutePageDto sysRoutePageDto) {
        Page<SysRoute> pageParam = new Page<>(sysRoutePageDto.getCurrentPage(), sysRoutePageDto.getPageSize());
        LambdaQueryWrapper<SysRoute> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNoneBlank(sysRoutePageDto.getName()), SysRoute::getName, sysRoutePageDto.getName())
                .between(!Objects.isNull(sysRoutePageDto.getStartCreateTime()) && !Objects.isNull(sysRoutePageDto.getEndCreateTime()), SysRoute::getCreateTime, sysRoutePageDto.getStartCreateTime(), sysRoutePageDto.getEndCreateTime())
                .orderByDesc(SysRoute::getCreateTime);
        Page<SysRoute> page = iSysRouteService.page(pageParam, queryWrapper);
        return Result.ok(PageData.init(ConvertUtils.sourceToTarget(page.getRecords(), SysRouteDto.class), page.getTotal()));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<?> set(SysRouteUserSetDto sysRouteUserSetDto) {
        LambdaQueryWrapper<SysUserRoute> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRoute::getUserId, sysRouteUserSetDto.getUserId());
        iSysUserRouteService.remove(queryWrapper);
        LocalDateTime now = LocalDateTime.now();
        List<SysUserRoute> sysUserRouteList = new ArrayList<>();
        sysRouteUserSetDto.getRouteIds().forEach(entity -> {
            SysUserRoute sysUserRoute = new SysUserRoute();
            sysUserRoute.setUserId(sysRouteUserSetDto.getUserId());
            sysUserRoute.setRouteId(entity);
            sysUserRoute.setCreateTime(now);
            sysUserRoute.setUpdateTime(now);
            sysUserRouteList.add(sysUserRoute);
        });
        iSysUserRouteService.saveBatch(sysUserRouteList);
        return Result.ok();
    }
}
