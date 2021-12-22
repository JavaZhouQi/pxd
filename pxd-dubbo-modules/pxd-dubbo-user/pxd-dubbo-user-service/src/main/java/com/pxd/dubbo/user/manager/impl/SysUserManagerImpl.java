package com.pxd.dubbo.user.manager.impl;

import com.pxd.dubbo.user.entity.SysUser;
import com.pxd.dubbo.user.mapper.SysUserMapper;
import com.pxd.dubbo.user.manager.SysUserManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author PiXiaoDan
 * @since 2021-12-22
 */
@Service
public class SysUserManagerImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserManager {

}
