package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class PddGoodsDetailReq extends DtkBaseReq {

    /*** 商品goodsSign，支持通过goodsSign查询商品。goodsSign是加密后的goodsId */
    private String goodsSign;
    /*** 搜索id，建议填写，可提高收益。可通过pdd.ddk.goods.recommend.get、pdd.ddk.goods.search、pdd.ddk.top.goods.list.query等接口获取*/
    private String searchId ;
    /*** 商品主图类型：1-场景图，2-白底图，默认为0 */
    private String goodsImgType ;
    /*** 商品ID（11/29新增字段） */
    private String goodsId ;

}
