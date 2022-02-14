package com.pxd.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class SysUserVo {

    @Length(min = 6,message = "用户名长度最小为6位")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Length(min = 6,message = "密码长度最小为6位")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

}
