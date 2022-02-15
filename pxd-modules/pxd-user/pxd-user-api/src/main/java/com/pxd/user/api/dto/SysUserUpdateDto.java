package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户修改对象")
public class SysUserUpdateDto extends SysUserAddDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

}
