package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class ListSuperGoodsResp {

    private Long totalNum;

    private Long pageId;

    private List<GoodsResp> list;

    @Data
    public static class GoodsResp {

        /*** 商品id */
        private String id;
        /*** 淘宝商品id */
        private String goodsId;
        /*** 淘宝标题 */
        private String title;
        /***短标题 */
        private String dtitle;
        /*** 商品原价 */
        private String originalPrice;
        /*** 券后价 */
        private String actualPrice;
        /*** 店铺类型，1-天猫，0-淘宝 */
        private String shopType;
        /*** 30天销量 */
        private String monthSales;
        /*** 2小时销量 */
        private String twoHoursSales;
        /*** 当天销量 */
        private String dailySales;
        /*** 佣金类型，0-通用，1-定向，2-高佣，3-营销计划 */
        private String commissionType;
        /*** 推广文案 */
        private String desc;
        /*** 领券量 */
        private String couponReceiveNum;
        /***  优惠券链接 */
        private String couponLink;
        /*** 优惠券结束时间 */
        private String couponEndTime;
        /*** 优惠券开始时间 */
        private String couponStartTime;
        /*** 优惠券金额 */
        private String couponPrice;
        /*** 优惠券使用条件 */
        private String couponConditions;
        /*** 活动类型，1-无活动，2-淘抢购，3-聚划算 */
        private String activityType;
        /*** 商品上架时间 */
        private String createTime;
        /*** 商品主图链接 */
        private String mainPic;
        /*** 营销主图链接 */
        private String marketingMainPic;
        /*** 淘宝卖家id */
        private String sellerId;
        /*** 商品在大淘客的分类id */
        private String cid;
        /*** 商品在大淘客的二级分类id，该分类为前端分类，一个商品可能有多个二级分类id */
        private String subcid;
        /*** 商品在淘宝的分类id */
        private String tbcid;
        /*** 折扣力度  */
        private String discounts;
        /*** 佣金比例 */
        private String commissionRate;
        /*** 券总量 */
        private String couponTotalNum;
        /*** 活动开始时间 */
        private String activityStartTime;
        /*** 活动结束时间 */
        private String activityEndTime;
        /*** 店铺名称 */
        private String shopName;
        /*** 淘宝店铺等级 */
        private String shopLevel;
        /*** 描述分 */
        private String descScore;
        /*** 描述相符 */
        private String dsrScore;
        /*** 描述同行比 */
        private String dsrPercent;
        /*** 物流服务 */
        private String shipScore;
        /*** 物流同行比 */
        private String shipPercent;
        /*** 服务态度 */
        private String serviceScore;
        /*** 服务同行比 */
        private String servicePercent;
        /*** 是否是品牌商品 */
        private String brand;
        /***品牌id */
        private String brandId;
        /*** 品牌名称 */
        private String brandName;
        /***  热推值 */
        private String hotPush;
        /*** 啊甘团队”放单人名称“ */
        private String teamName;
        /*** “https://detail.tmall.com/item.htm?id=589284195570“ 商品淘宝链接 */
        private String itemLink;
        /*** 定金，若无定金，则显示0 */
        private String quanMLink;
        /*** 立减，若无立减金额，则显示0 */
        private String hzQuanOver;
        /***    0.不包运费险 1.包运费险*/
        private String yunfeixian;
        /*** 预估淘礼金 */
        private String estimateAmount;
        /*** 偏远地区包邮，0.不包邮，1.包邮 */
        private String freeshipRemoteDistrict;
        /*** 品牌列表（搜索结果商品所包含的所有品牌信息，可以作为条件筛选）2021/15新增字段 */
        private List<Brand> brandList;
        /*** 1.购物津贴；2.跨店满减；0.无（10/27新增字段） */
        private String discountType;
        /*** 活动满减的满值（10/27新增字段） */
        private String discountFull;
        /*** 活动（10/27新增字段） */
        private String discountCut;
        /*** 热门活动ID（10/27新增;字段） */
        private String marketGroup;
        /*** 活动信息（10/27新增字段） */
        private ActivityInfo activityInfo;
        /*** 商品是否已经验货，0-否；1-是（1/26新增字段） */
        private String inspectedGoods;
        /*** 店铺logo */
        private String shopLogo;

        @Data
        private static class ActivityInfo{

            /*** 活动名称（10/27新增字段） */
            private String activityName;
            /*** 活动ID（10/27新增字段） */
            private String activityId;

        }

        @Data
        private static class Brand {

            /*** 品牌ID(2021/1/15新增字段) */
            private String brandId;
            /*** 品牌logo地址(2021/1/15新增字段) */
            private String brandLogo;
            /*** 品牌名称(2021/1/15新增字段) */
            private String brandName;

        }

    }
}
