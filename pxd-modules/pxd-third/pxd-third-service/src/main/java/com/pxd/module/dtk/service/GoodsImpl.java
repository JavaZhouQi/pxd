package com.pxd.module.dtk.service;


import com.pxd.dto.goods.*;

public interface GoodsImpl {

    String getPlatform();

    /*** 搜索 */
    SearchResp search(SearchReq searchReq);

    /*** 商品详情 */
    DetailsResp details(String goodsId);

    /*** 转链 */
    TurnLinkResp turnLink(TurnLinkReq turnLinkReq);

}
