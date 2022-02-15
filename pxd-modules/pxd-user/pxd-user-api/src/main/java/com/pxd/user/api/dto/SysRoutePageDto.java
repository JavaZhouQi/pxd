package com.pxd.user.api.dto;

import com.pxd.common.result.page.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "路由分页信息")
public class SysRoutePageDto extends PageParam implements Serializable {

    @ApiModelProperty("名称")
    private String name;
//
//    @ApiModelProperty("路径")
//    private String path;
//
//    @ApiModelProperty("附属信息")
//    private String meta;
//
//    @ApiModelProperty("权限")
//    private String permission;

    @ApiModelProperty(value = "路由创建时间-开始")
    private LocalDateTime startCreateTime;

    @ApiModelProperty(value = "路由创建时间-结束")
    private LocalDateTime endCreateTime;

}
