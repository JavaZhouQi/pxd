package com.pxd.dubbo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pxd.common.base.utils.ConvertUtils;
import com.pxd.common.result.page.PageData;
import com.pxd.common.result.result.Result;
import com.pxd.entity.SysUser;
import com.pxd.service.ISysUserService;
import com.pxd.user.api.dto.SysUserAddDto;
import com.pxd.user.api.dto.SysUserDto;
import com.pxd.user.api.dto.SysUserPageDto;
import com.pxd.user.api.dto.SysUserUpdateDto;
import com.pxd.user.api.dubbo.SysUserDubbo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@DubboService
public class SysUserDubboImpl implements SysUserDubbo {

    ISysUserService sysUserService;

    @Override
    public Result<SysUserDto> findById(Long userId) {
        SysUser sysUser = sysUserService.getById(userId);
        if (sysUser == null) {
            return Result.error("数据不存在");
        }
        return Result.ok(ConvertUtils.sourceToTarget(sysUser, SysUserDto.class));
    }

    @Override
    public Result<?> add(SysUserAddDto sysUserAddDto) {
        if (findByUsername(sysUserAddDto.getUsername()) != null) {
            return Result.error("账号已存在");
        }
        SysUser sysUser = ConvertUtils.sourceToTarget(sysUserAddDto, SysUser.class);
        LocalDateTime now = LocalDateTime.now();
        sysUser.setCreateTime(now);
        sysUser.setUpdateTime(now);
        sysUserService.save(sysUser);
        return Result.ok();
    }

    @Override
    public Result<?> update(SysUserUpdateDto sysUserUpdateDto) {
        SysUserDto byUsername = findByUsername(sysUserUpdateDto.getUsername());
        if (byUsername != null && !Objects.equals(byUsername.getId(), sysUserUpdateDto.getId())) {
            return Result.error("账号已存在");
        }
        SysUser sysUser = sysUserService.getById(sysUserUpdateDto.getId());
        if (sysUser == null) {
            return Result.error("数据不存在");
        }
        BeanUtils.copyProperties(sysUserUpdateDto, sysUser);
        sysUser.setUpdateTime(LocalDateTime.now());
        sysUserService.updateById(sysUser);
        return Result.ok();
    }

    @Override
    public Result<?> del(Long id) {
        return sysUserService.removeById(id) ? Result.ok() : Result.error();
    }

    @Override
    public Result<PageData<SysUserDto>> page(SysUserPageDto sysUserPageDto) {
        Page<SysUser> pageParam = new Page<>(sysUserPageDto.getCurrentPage(), sysUserPageDto.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNoneBlank(sysUserPageDto.getUsername()), SysUser::getUsername, sysUserPageDto.getUsername())
                .eq(!Objects.isNull(sysUserPageDto.getStatus()), SysUser::getStatus, sysUserPageDto.getStatus())
                .between(!Objects.isNull(sysUserPageDto.getStartCreateTime()) && !Objects.isNull(sysUserPageDto.getEndCreateTime()), SysUser::getCreateTime, sysUserPageDto.getStartCreateTime(), sysUserPageDto.getEndCreateTime())
                .orderByDesc(SysUser::getCreateTime);
        Page<SysUser> page = sysUserService.page(pageParam, queryWrapper);
        return Result.ok(PageData.init(ConvertUtils.sourceToTarget(page.getRecords(), SysUserDto.class), page.getTotal()));
    }

    @Override
    public SysUserDto findByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser == null) {
            return null;
        }
        return ConvertUtils.sourceToTarget(sysUser, SysUserDto.class);
    }
}
