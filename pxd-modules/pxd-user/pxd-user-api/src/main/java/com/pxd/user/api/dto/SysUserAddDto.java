package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "用户新增对象")
public class SysUserAddDto implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, message = "用户名最少不低于六位")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, message = "密码最少不低于六位")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态 1可用 0不可用 默认：1")
    private Integer status = 1;

}
