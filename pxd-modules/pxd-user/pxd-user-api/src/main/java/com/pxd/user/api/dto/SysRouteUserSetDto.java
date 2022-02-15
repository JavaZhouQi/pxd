package com.pxd.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@ApiModel(value = "用户路由关联")
public class SysRouteUserSetDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("路由id")
    private Set<Long> routeIds;

}
