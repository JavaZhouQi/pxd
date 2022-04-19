package com.pxd.service;


import com.pxd.dto.goods.*;

import java.util.List;

public interface GoodsService {

    /*** 热词 */
    List<String> getHotWords();

    /*** 联想词 */
    List<String> associationalWord(String text);

    /*** 搜索 */
    SearchResp search(SearchReq searchReq);

    /*** 商品详情 */
    DetailsResp details(String platform, String goodsId);

    /*** 转链 */
    TurnLinkResp turnLink(TurnLinkReq turnLinkReq);
}
