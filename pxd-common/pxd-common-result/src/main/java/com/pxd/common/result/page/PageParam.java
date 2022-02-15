package com.pxd.common.result.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "分页参数")
public class PageParam implements Serializable {

    @ApiModelProperty(value = "当前页码")
    private Long currentPage = 1L;

    @ApiModelProperty(value = "每页显示记录数")
    private Long pageSize = 10L;
}
