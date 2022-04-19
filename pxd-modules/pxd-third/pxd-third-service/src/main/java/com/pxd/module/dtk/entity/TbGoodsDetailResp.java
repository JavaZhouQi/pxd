package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class TbGoodsDetailResp {

    /*** 商品id,若查询结果id=-1，则说明该商品非大淘客平台商品，数据为淘宝直接返回的数据，由于淘宝数据的缓存时间相对较长，会出现商品信息和详情信息不一致的情况 */
    private String id;
    /*** 淘宝商品id */
    private String goodsId;
    /*** 商品淘宝链接 */
    private String itemLink;
    /*** 淘宝标题 */
    private String title;
    /*** 大淘客短标题 */
    private String dtitle;
    /*** 特色文案（商品卖点） */
    private List<String> specialText;
    /*** 推广文案 */
    private String desc;
    /*** 商品在大淘客的分类id */
    private String cid;
    /*** 商品在大淘客的二级分类id，该分类为前端分类，一个商品可能有多个二级分类id */
    private List<String> subcid;
    /*** 商品在淘宝的分类id */
    private String tbcid;
    /*** 商品主图链接 */
    private String mainPic;
    /*** 营销主图链接 */
    private String marketingMainPic;
    /*** 商品视频（新增字段） */
    private String video;
    /*** 商品原价 */
    private String originalPrice;
    /*** 券后价 */
    private String actualPrice;
    /*** 折扣力度 */
    private String discounts;
    /*** 佣金类型，0-通用，1-定向，2-高佣，3-营销计划 */
    private String commissionType;
    /***  佣金比例*/
    private String commissionRate;
    /*** 优惠券链接 */
    private String couponLink;
    /*** 券总量 */
    private String couponTotalNum;
    /*** 领券量 */
    private String couponReceiveNum;
    /*** 优惠券结束时间 */
    private String couponEndTime;
    /*** 优惠券开始时间 */
    private String couponStartTime;
    /*** 优惠券金额 */
    private String couponPrice;
    /***  优惠券使用条件 */
    private String couponConditions;
    /*** 30天销量 */
    private String monthSales;
    /***  2小时销量 */
    private String twoHoursSales;
    /*** 当天销量 */
    private String dailySales;
    /*** 是否是品牌商品 */
    private String brand;
    /*** 品牌id */
    private String brandId;
    /*** 品牌名称 */
    private String brandName;
    /*** 商品上架时间 */
    private String createTime;
    /***  活动类型，1-无活动，2-淘抢购，3-聚划算 */
    private String activityType;
    /*** 活动开始时间 */
    private String activityStartTime;
    /*** 活动结束时间 */
    private String activityEndTime;
    /*** 店铺类型，1-天猫，0-淘宝 */
    private String shopType;
    /*** 是否金牌卖家，1-金牌卖家，0-非金牌卖家 */
    private String goldSellers;
    /*** 淘宝卖家id，也是店铺id。店铺转链可用此字段 */
    private String sellerId;
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
    /*** 热推值 */
    private String hotPush;
    /*** 放单人名称 */
    private String teamName;
    /*** 商品详情图（需要做适配） */
    private List<DetailPic> detailPics;
    /*** 淘宝轮播图 */
    private String imgs;
    /*** 相关商品图 */
    private String reimgs;
    /*** 定金，若无定金，则显示0 */
    private String quanMLink;
    /*** 立减，若无立减金额，则显示0 */
    private String hzQuanOver;
    /***  0.不包运费险 1.包运费险 */
    private String yunfeixian;
    /*** 预估淘礼金 */
    private String estimateAmount;
    /*** 店铺logo */
    private String shopLogo;
    /*** 偏远地区包邮，0.不包邮，1.包邮 */
    private String freeshipRemoteDistrict;
    /*** 该商品是否有细分类目：0不是，1是 */
    private String isSubdivision;
    /*** 该商品所属细分类目id */
    private String subdivisionId;
    /*** 该商品所属细分类目名称 */
    private String subdivisionName;
    /*** 该商品所属细分类目排名 */
    private String subdivisionRank;
    /*** 定向佣金类型，1非定向，3定向佣金 */
    private String directCommissionType;
    /*** 定向佣金 */
    private String directCommission;
    /*** 定向链接 */
    private String directCommissionLink;
    /*** 24小时销量（8/17新增字段） */
    private String sales24h;
    /*** 是否近30天历史最低价，0-否；1-是(8/18新增字段) */
    private String lowest;
    /*** 优惠券ID(9/15新增字段) */
    private String couponId;
    /*** 1.购物津贴；2.跨店满减；0.无(10/27新增字段) */
    private String discountType;
    /*** 活动满减的满值(10/27新增字段) */
    private String discountFull;
    /*** 活动满减的减值(10/27新增字段) */
    private String discountCut;
    /*** 活动信息(10/27新增字段) */
    private MarketGroup marketGroup;
    /*** 单单有奖奖励金额(1/10新增字段) */
    private String cpaRewardAmount;
    /*** 商品是否已经验货，0-否；1-是(1/26新增字段) */
    private String inspectedGoods;

    @Data
    public static class MarketGroup{
        /*** 活动信息(10/27新增字段) */
        private String activityInfo;
        /*** 活动名称(10/27新增字段) */
        private String activityName;
        /*** 活动ID(10/27新增字段) */
        private String activityId;
    }

    @Data
    public static class DetailPic {
        private String hotAreaList;
        private String img;
        private String width;
        private String height;
    }
}
