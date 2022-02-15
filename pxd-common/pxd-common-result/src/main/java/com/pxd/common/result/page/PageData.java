package com.pxd.common.result.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "分页数据")
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总记录数")
    private long total;

    @ApiModelProperty(value = "列表数据")
    private List<T> list;

    public static <T> PageData<T> init(List<T> list, long total) {
        PageData<T> tPageData = new PageData<>();
        tPageData.setList(list);
        tPageData.setTotal(total);
        return tPageData;
    }
}