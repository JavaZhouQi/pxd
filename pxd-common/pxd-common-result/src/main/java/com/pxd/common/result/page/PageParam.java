package com.pxd.common.result.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@ApiModel(value = "分页参数")
public class PageParam implements Serializable {

    @Min(value = 1, message = "当前页码最小为1")
    @ApiModelProperty(value = "当前页码")
    private Long currentPage = 1L;

    @Min(value = 1, message = "每页显示记录数最小为1")
    @Max(value = 100, message = "每页显示记录数最大为100")
    @ApiModelProperty(value = "每页显示记录数")
    private Long pageSize = 10L;
}
