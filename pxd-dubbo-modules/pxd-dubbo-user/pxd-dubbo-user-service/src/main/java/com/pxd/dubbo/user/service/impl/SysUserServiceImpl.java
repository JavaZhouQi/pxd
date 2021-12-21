package com.pxd.dubbo.user.service.impl;

import com.pxd.dubbo.user.entity.SysUser;
import com.pxd.dubbo.user.mapper.SysUserMapper;
import com.pxd.dubbo.user.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
