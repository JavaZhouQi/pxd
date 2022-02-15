package com.pxd.user.api.dto;

import com.pxd.common.result.page.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "用户分页查询对象")
public class SysUserPageDto extends PageParam implements Serializable {

    @ApiModelProperty(value = "用户名（模糊查询）")
    private String username;

    @ApiModelProperty(value = "状态 1 可用 0不可用")
    private Integer status;

    @ApiModelProperty(value = "用户创建时间-开始")
    private LocalDateTime startCreateTime;

    @ApiModelProperty(value = "用户创建时间-结束")
    private LocalDateTime endCreateTime;

}
