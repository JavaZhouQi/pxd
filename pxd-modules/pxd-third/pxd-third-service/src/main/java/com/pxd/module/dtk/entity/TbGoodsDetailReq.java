package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class TbGoodsDetailReq extends DtkBaseReq {

    /*** 大淘客商品id，请求时id或goodsId必填其中一个，若均填写，将优先查找当前单品id*/
    private String id;
    /*** 淘宝商品id，id或goodsId必填其中一个，若均填写，将优先查找当前单品id */
    private String goodsId;

}
