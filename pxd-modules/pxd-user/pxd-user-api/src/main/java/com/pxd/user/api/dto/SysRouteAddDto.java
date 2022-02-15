package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "路由添加信息")
public class SysRouteAddDto implements Serializable {

    @ApiModelProperty("父id 默认：0")
    private Long parentId = 0L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("附属信息")
    private String meta;

    @ApiModelProperty("权限")
    private String permission;

}
