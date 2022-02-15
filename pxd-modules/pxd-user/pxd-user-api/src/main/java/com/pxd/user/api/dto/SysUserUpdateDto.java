package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "用户修改对象")
public class SysUserUpdateDto extends SysUserAddDto implements Serializable {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id")
    private Long id;

}
