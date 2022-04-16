package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class JdGoodsDetailReq extends DtkBaseReq {

    /*** 商品skuId，多个使用逗号分隔，最多支持10个skuId同时查询（需使用半角状态下的逗号） */
    private String skuIds;

}
