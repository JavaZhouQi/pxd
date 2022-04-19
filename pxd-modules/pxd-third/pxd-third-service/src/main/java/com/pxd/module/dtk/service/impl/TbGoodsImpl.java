package com.pxd.module.dtk.service.impl;

import com.pxd.common.base.utils.ConvertUtils;
import org.springframework.stereotype.Service;
import com.pxd.dto.goods.*;
import com.pxd.enums.PlatformEnum;
import com.pxd.module.dtk.entity.*;
import com.pxd.module.dtk.service.GoodsImpl;
import com.pxd.module.dtk.util.DtkUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TbGoodsImpl implements GoodsImpl {

    @Override
    public String getPlatform() {
        return PlatformEnum.TB.getPlatform();
    }

    @Override
    public SearchResp search(SearchReq searchReq) {
        ListSuperGoodsReq listSuperGoodsReq = new ListSuperGoodsReq();
        listSuperGoodsReq.setPageId(searchReq.getPage());
        listSuperGoodsReq.setPageSize(searchReq.getPageSize());
        listSuperGoodsReq.setKeyWords(searchReq.getText());
        listSuperGoodsReq.setHasCoupon(searchReq.getHasCoupon());
        listSuperGoodsReq.setTmall(searchReq.getTbCondition().getTmall());
        listSuperGoodsReq.setSort(searchReq.getTbCondition().getSort());
        ListSuperGoodsResp listSuperGoodsResp = DtkUtil.listSuperGoods(listSuperGoodsReq);
        List<SearchResp.GoodsInfo> list = new ArrayList<>();
        for (ListSuperGoodsResp.GoodsResp goodsResp : listSuperGoodsResp.getList()) {
            SearchResp.GoodsInfo goodsInfo = new SearchResp.GoodsInfo();
            goodsInfo.setGoodsId(goodsResp.getGoodsId());
            goodsInfo.setTitle(goodsResp.getTitle());
            goodsInfo.setOriginalPrice(goodsResp.getOriginalPrice());
            goodsInfo.setActualPrice(goodsResp.getActualPrice());
            goodsInfo.setSales(goodsResp.getMonthSales());
            goodsInfo.setMainPic(goodsResp.getMainPic());
            goodsInfo.setShopName(goodsResp.getShopName());
            list.add(goodsInfo);
        }
        return SearchResp.init(listSuperGoodsResp.getPageId(), listSuperGoodsResp.getTotalNum(), list);
    }

    @Override
    public DetailsResp details(String goodsId) {
        TbGoodsDetailReq tbGoodsDetailReq = new TbGoodsDetailReq();
        tbGoodsDetailReq.setGoodsId(goodsId);
        TbGoodsDetailResp tbGoodsDetailResp = DtkUtil.tbGoodsDetail(tbGoodsDetailReq);
        DetailsResp detailsResp = ConvertUtils.sourceToTarget(tbGoodsDetailResp, DetailsResp.class);
        detailsResp.setDetailPics(tbGoodsDetailResp.getDetailPics().stream().map(TbGoodsDetailResp.DetailPic::getImg).collect(Collectors.toList()));
        detailsResp.setSales(tbGoodsDetailResp.getMonthSales());
        return detailsResp;
    }

    @Override
    public TurnLinkResp turnLink(TurnLinkReq turnLinkReq) {
        TbToLinkReq tbToLinkReq = new TbToLinkReq();
        tbToLinkReq.setGoodsId(turnLinkReq.getGoodsId());
        TbToLinkResp tbToLinkResp = DtkUtil.tbToLink(tbToLinkReq);
        TurnLinkResp turnLinkResp = new TurnLinkResp();
        turnLinkResp.setCouponUrl(tbToLinkResp.getCouponClickUrl());
        turnLinkResp.setShortUrl(tbToLinkResp.getShortUrl());
        turnLinkResp.setTpwd(tbToLinkResp.getTpwd());
        turnLinkResp.setLongTpwd(tbToLinkResp.getLongTpwd());
        return turnLinkResp;
    }
}
