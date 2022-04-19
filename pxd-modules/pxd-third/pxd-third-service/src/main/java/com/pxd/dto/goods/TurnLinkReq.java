package com.pxd.dto.goods;

import com.pxd.enums.PlatformEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TurnLinkReq {

    @NotBlank(message = "平台不能为空")
    @ApiModelProperty(value = "平台 tb:淘宝，jd:京东，pdd:拼多多 默认：tb")
    private String platform = PlatformEnum.TB.getPlatform();

    @NotBlank(message = "商品id不能为空")
    @ApiModelProperty(value = "商品id")
    private String goodsId;

}
