package com.pxd.module.dtk.service.impl;


import com.pxd.dto.goods.*;
import com.pxd.enums.PlatformEnum;
import com.pxd.module.dtk.entity.*;
import com.pxd.module.dtk.service.GoodsImpl;
import com.pxd.module.dtk.util.DtkUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PddGoodsImpl implements GoodsImpl {

    @Override
    public String getPlatform() {
        return PlatformEnum.PDD.getPlatform();
    }

    @Override
    public SearchResp search(SearchReq searchReq) {
        PddGoodsSearchReq pddGoodsSearchReq = new PddGoodsSearchReq();
        pddGoodsSearchReq.setIsBrandGoods(searchReq.getPddCondition().getIsBrandGoods());
        pddGoodsSearchReq.setMerchantTypeList(searchReq.getPddCondition().getMerchantTypeList());
        pddGoodsSearchReq.setPage(searchReq.getPage());
        pddGoodsSearchReq.setPageSize(searchReq.getPageSize());
        pddGoodsSearchReq.setSortType(searchReq.getPddCondition().getSortType());
        pddGoodsSearchReq.setWithCoupon(searchReq.getHasCoupon());
        pddGoodsSearchReq.setKeyword(searchReq.getText());
        PddGoodsSearchResp pddGoodsSearchResp = DtkUtil.pddGoodsSearch(pddGoodsSearchReq);
        ArrayList<SearchResp.GoodsInfo> list = new ArrayList<>();
        for (PddGoodsSearchResp.GoodsResp goodsResp : pddGoodsSearchResp.getGoodsList()) {
            SearchResp.GoodsInfo goodsInfo = new SearchResp.GoodsInfo();
            goodsInfo.setGoodsId(goodsResp.getGoodsSign());
            goodsInfo.setTitle(goodsResp.getGoodsName());
            goodsInfo.setOriginalPrice(goodsResp.getMinNormalPrice());
            goodsInfo.setActualPrice(goodsResp.getCouponMinOrderAmount());
            goodsInfo.setSales(goodsResp.getSalesTip());
            goodsInfo.setMainPic(goodsResp.getGoodsImageUrl());
            goodsInfo.setShopName(goodsResp.getMallName());
            list.add(goodsInfo);
        }
        return SearchResp.init(pddGoodsSearchResp.getListId(), pddGoodsSearchResp.getTotalCount(), list);
    }

    @Override
    public DetailsResp details(String goodsId) {
        PddGoodsDetailReq pddGoodsDetailReq = new PddGoodsDetailReq();
        pddGoodsDetailReq.setGoodsSign(goodsId);
        PddGoodsDetailResp pddGoodsDetailResp = DtkUtil.pddGoodsDetail(pddGoodsDetailReq);
        DetailsResp detailsResp = new DetailsResp();
        detailsResp.setGoodsId(pddGoodsDetailResp.getGoodsSign());
        detailsResp.setTitle(pddGoodsDetailResp.getGoodsName());
        detailsResp.setOriginalPrice(pddGoodsDetailResp.getMinNormalPrice());
        detailsResp.setActualPrice(pddGoodsDetailResp.getCouponMinOrderAmount());
        detailsResp.setSales(pddGoodsDetailResp.getSalesTip());
        detailsResp.setMainPic(pddGoodsDetailResp.getGoodsImageUrl());
        detailsResp.setShopName(pddGoodsDetailResp.getMallName());
        detailsResp.setDsrScore(pddGoodsDetailResp.getDescTxt());
        detailsResp.setShipScore(pddGoodsDetailResp.getLgstTxt());
        detailsResp.setServiceScore(pddGoodsDetailResp.getServTxt());
        detailsResp.setDetailPics(pddGoodsDetailResp.getGoodsGalleryUrls());
        return detailsResp;
    }

    @Override
    public TurnLinkResp turnLink(TurnLinkReq turnLinkReq) {
        PddToLinkReq pddToLinkReq = new PddToLinkReq();
        pddToLinkReq.setPid("10787417_245588117");
        pddToLinkReq.setGoodsSign(turnLinkReq.getGoodsId());
        PddToLinkResp pddToLinkResp = DtkUtil.pddToLink(pddToLinkReq);
        TurnLinkResp turnLinkResp = new TurnLinkResp();
        turnLinkResp.setCouponUrl(pddToLinkResp.getMobileUrl());
        turnLinkResp.setShortUrl(pddToLinkResp.getMobileShortUrl());
        return turnLinkResp;
    }
}
