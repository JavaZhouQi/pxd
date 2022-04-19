package com.pxd.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResp {

    @ApiModelProperty(value = "当前页")
    private String page;
    @ApiModelProperty(value = "总数")
    private String total;
    @ApiModelProperty(value = "商品数据")
    private List<GoodsInfo> goodsInfoList;

    @Data
    public static class GoodsInfo {
        @ApiModelProperty(value = "商品ID")
        private String goodsId;
        @ApiModelProperty(value = "标题")
        private String title;
        @ApiModelProperty(value = "商品原价")
        private String originalPrice;
        @ApiModelProperty(value = "券后价（到手价）")
        private String actualPrice;
        @ApiModelProperty(value = "销量（月销量）")
        private String sales;
        @ApiModelProperty(value = "商品主图链接")
        private String mainPic;
        @ApiModelProperty(value = "店铺名称")
        private String shopName;
    }

    public static SearchResp init(String page, String total, List<GoodsInfo> goodsInfoList) {
        SearchResp searchResp = new SearchResp();
        searchResp.setPage(page);
        searchResp.setTotal(total);
        searchResp.setGoodsInfoList(goodsInfoList);
        return searchResp;
    }

}
