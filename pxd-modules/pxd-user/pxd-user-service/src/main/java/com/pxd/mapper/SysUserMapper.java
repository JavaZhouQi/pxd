package com.pxd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pxd.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author PiXiaoDan
 * @since 2021-12-22
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
