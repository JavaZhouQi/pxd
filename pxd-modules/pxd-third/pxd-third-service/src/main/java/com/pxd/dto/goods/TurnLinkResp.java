package com.pxd.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TurnLinkResp {

    @ApiModelProperty(value = "优惠券链接")
    private String couponUrl;

    @ApiModelProperty(value = "短链接")
    private String shortUrl;

    @ApiModelProperty(value = "淘口令")
    private String tpwd;

    @ApiModelProperty(value = "针对iOS14版本，增加对应能解析的长口令")
    private String longTpwd;

}
