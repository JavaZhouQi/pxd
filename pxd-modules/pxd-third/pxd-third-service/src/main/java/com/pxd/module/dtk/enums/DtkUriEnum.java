package com.pxd.module.dtk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DtkUriEnum {

    LIST_SUPER_GOODS("/goods/list-super-goods", "超级搜索", "v1.3.0"),
    PDD_GOODS_SEARCH("/dels/pdd/goods/search", "拼多多联盟搜索", "v2.0.0"),
    JD_GOODS_SEARCH("/dels/jd/goods/search", "京东联盟搜索", "v1.0.0"),
    CATEGORY_HOT("/category/get-top100", "热搜记录", "v1.0.1"),
    PDD_GOODS_DETAIL("/dels/pdd/goods/detail", "拼多多商品详情", "v2.0.0"),
    TB_GOODS_DETAIL("/goods/get-goods-details", "单品详情", "v1.2.3"),
    JD_GOODS_DETAIL("/dels/jd/goods/get-details", "单品详情", "v1.0.0"),
    TB_TO_LINK("/tb-service/get-privilege-link", "高效转链", "v1.3.1"),
    JD_TO_LINK("/dels/jd/kit/promotion-union-convert", "京东商品转链", "v1.0.0"),
    PDD_TO_LINK("/dels/pdd/kit/goods-prom-generate", "拼多多商品转链", "v2.0.0"),
    SEARCH_SUGGESTION("/goods/search-suggestion", "联想词", "v1.0.2"),
    COMMENT_LIST("/comment/get-comment-list", "商品评论", "v1.0.0"),

    ;
    private String uri;
    private String desc;
    private String version;
}
