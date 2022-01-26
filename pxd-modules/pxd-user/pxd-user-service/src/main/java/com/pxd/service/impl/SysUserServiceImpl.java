package com.pxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxd.entity.SysUser;
import com.pxd.mapper.SysUserMapper;
import com.pxd.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    
}
