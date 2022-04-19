package com.pxd.module.dtk.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.pxd.dto.goods.*;
import com.pxd.enums.PlatformEnum;
import com.pxd.module.dtk.entity.*;
import com.pxd.module.dtk.service.GoodsImpl;
import com.pxd.module.dtk.util.DtkUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdGoodsImpl implements GoodsImpl {
    @Override
    public String getPlatform() {
        return PlatformEnum.JD.getPlatform();
    }

    @Override
    public SearchResp search(SearchReq searchReq) {
        JdGoodsSearchReq jdGoodsSearchReq = new JdGoodsSearchReq();
        jdGoodsSearchReq.setPageId(searchReq.getPage());
        jdGoodsSearchReq.setPageSize(searchReq.getPageSize());
        jdGoodsSearchReq.setKeyword(searchReq.getText());
        jdGoodsSearchReq.setPriceFrom(searchReq.getJdCondition().getPriceFrom());
        jdGoodsSearchReq.setPriceTo(searchReq.getJdCondition().getPriceTo());
        jdGoodsSearchReq.setOwner(searchReq.getJdCondition().getOwner());
        jdGoodsSearchReq.setSortName(searchReq.getJdCondition().getSortName());
        jdGoodsSearchReq.setSort(searchReq.getJdCondition().getSort());
        jdGoodsSearchReq.setIsCoupon(searchReq.getHasCoupon());
        jdGoodsSearchReq.setPingouPriceStart(searchReq.getJdCondition().getPingouPriceStart());
        jdGoodsSearchReq.setPingouPriceEnd(searchReq.getJdCondition().getPingouPriceEnd());
        JdGoodsSearchResp jdGoodsSearchResp = DtkUtil.jdGoodsSearch(jdGoodsSearchReq);
        List<SearchResp.GoodsInfo> list = new ArrayList<>();
        for (JdGoodsSearchResp.GoodsResp jdGoods : jdGoodsSearchResp.getList()) {
            SearchResp.GoodsInfo goodsInfo = new SearchResp.GoodsInfo();
            goodsInfo.setGoodsId(jdGoods.getSkuId());
            goodsInfo.setTitle(jdGoods.getSkuName());
            goodsInfo.setOriginalPrice(jdGoods.getPrice());
            goodsInfo.setActualPrice(jdGoods.getLowestCouponPrice());
            goodsInfo.setSales(jdGoods.getInOrderCount30Days());
            goodsInfo.setMainPic(jdGoods.getImageUrlList().get(0));
            goodsInfo.setShopName(jdGoods.getShopName());
            list.add(goodsInfo);
        }
        return SearchResp.init(jdGoodsSearchResp.getPageId(), jdGoodsSearchResp.getTotalNum(), list);
    }

    @Override
    public DetailsResp details(String goodsId) {
        JdGoodsDetailReq jdGoodsDetailReq = new JdGoodsDetailReq();
        jdGoodsDetailReq.setSkuIds(goodsId);
        List<JdGoodsDetailResp> list = DtkUtil.jdGoodsDetail(jdGoodsDetailReq);
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }
        JdGoodsDetailResp jdGoodsDetailResp = list.get(0);
        DetailsResp detailsResp = new DetailsResp();
        detailsResp.setGoodsId(jdGoodsDetailResp.getSkuId());
        detailsResp.setTitle(jdGoodsDetailResp.getSkuName());
        detailsResp.setOriginalPrice(jdGoodsDetailResp.getOriginPrice());
        detailsResp.setActualPrice(jdGoodsDetailResp.getActualPrice());
        detailsResp.setSales(jdGoodsDetailResp.getInOrderCount30Days());
        detailsResp.setMainPic(jdGoodsDetailResp.getPicMain());
        detailsResp.setShopName(jdGoodsDetailResp.getShopName());
        detailsResp.setDsrScore(jdGoodsDetailResp.getGoodsCommentShare());
        detailsResp.setDetailPics(jdGoodsDetailResp.getDetailImages());
        return detailsResp;
    }

    @Override
    public TurnLinkResp turnLink(TurnLinkReq turnLinkReq) {
        JdToLinkReq jdToLinkReq = new JdToLinkReq();
        jdToLinkReq.setUnionId("2025303688");
        jdToLinkReq.setMaterialId("https://item.jd.com/" + turnLinkReq.getGoodsId() + ".html");
        JdToLinkResp jdToLinkResp = DtkUtil.jdToLink(jdToLinkReq);
        TurnLinkResp turnLinkResp = new TurnLinkResp();
        turnLinkResp.setCouponUrl(jdToLinkResp.getLongUrl());
        turnLinkResp.setShortUrl(jdToLinkResp.getShortUrl());
        return turnLinkResp;
    }
}
