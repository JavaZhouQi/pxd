package com.pxd.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DetailsResp {

    @ApiModelProperty(value = "商品ID")
    private String goodsId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "商品原价")
    private String originalPrice;
    @ApiModelProperty(value = "券后价（到手价）")
    private String actualPrice;
    @ApiModelProperty(value = "销量")
    private String sales;
    @ApiModelProperty(value = "商品主图链接")
    private String mainPic;
    @ApiModelProperty(value = "店铺名称")
    private String shopName;
    @ApiModelProperty(value = "描述相符")
    private String dsrScore;
    @ApiModelProperty(value = "物流服务")
    private String shipScore;
    @ApiModelProperty(value = "服务态度")
    private String serviceScore;
    @ApiModelProperty(value = "商品详情图")
    private List<String> detailPics;

}
