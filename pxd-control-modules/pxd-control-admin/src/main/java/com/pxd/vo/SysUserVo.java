package com.pxd.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserVo {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}
