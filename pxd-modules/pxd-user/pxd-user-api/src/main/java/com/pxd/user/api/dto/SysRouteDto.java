package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "路由信息")
public class SysRouteDto implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("路径")
    private String path;

    @ApiModelProperty("附属信息")
    private String meta;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

}
