package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "路由修改信息")
public class SysRouteUpdateDto extends SysRouteAddDto implements Serializable {

    @ApiModelProperty("id")
    private Long id;

}
