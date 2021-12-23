package com.pxd.dubbo.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserDto implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
