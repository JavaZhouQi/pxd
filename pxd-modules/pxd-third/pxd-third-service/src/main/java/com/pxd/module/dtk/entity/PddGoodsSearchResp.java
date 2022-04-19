package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsSearchResp {

    private String listId;
    private String searchId;
    private String totalCount;
    private List<GoodsResp> goodsList;

    @Data
    public static class GoodsResp {
        /*** 商品活动标记数组，例：4,7，4-秒杀 7-百亿补贴等 */
        private List<String> activityTags;
        /***商品类目id */
        private String catIds;
        /*** 优惠券面额，单位为元 */
        private String couponDiscount;
        /*** 优惠券失效时间 */
        private String couponEndTime;
        /*** 优惠券门槛价格，单位为元 */
        private String couponMinOrderAmount;
        /*** 优惠券剩余数量 */
        private String couponRemainQuantity;
        /*** 优惠券生效时间 */
        private String couponStartTime;
        /*** 优惠券总数量 */
        private String couponTotalQuantity;
        /*** 描述分 */
        private String descTxt;
        /*** 商品描述 */
        private String goodsDesc;
        /*** 商品主图 */
        private String goodsImageUrl;
        /*** 商品名称 */
        private String goodsName;
        /*** 商品goodsSign，支持通过goodsSign查询商品。goodsSign是加密后的goodsId,goodsId已下线，请使用goodsSign来替代。使用说明：https://jinbao.pinduoduo.com/qa-system?questionId=252 */
        private String goodsSign;
        /*** 商品缩略图 */
        private String goodsThumbnailUrl;
        /*** 商品是否有优惠券 1-有，0-没有 */
        private String hasCoupon;
        /*** 是否有店铺券 1-有，0-没有 */
        private String hasMallCoupon;
        /*** 物流分 */
        private String lgstTxt;
        /*** 店铺券折扣 */
        private String mallCouponDiscountPct;
        /***  店铺券结束使用时间 */
        private String mallCouponEndTime;
        /*** 店铺券id */
        private String mallCouponId;
        /*** 最大使用金额 */
        private String mallCouponMaxDiscountAmount;
        /*** 最小使用金额 */
        private String mallCouponMinOrderAmount;
        /*** 店铺券余量 */
        private String mallCouponRemainQuantity;
        /***  店铺券开始使用时间 */
        private String mallCouponStartTime;
        /*** 店铺券总量 */
        private String mallCouponTotalQuantity;
        /*** 该商品所在店铺是否参与全店推广，0：否，1：是 */
        private String mallCps;
        /*** 店铺id */
        private String mallId;
        /*** 店铺名字 */
        private String mallName;
        /*** 店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店 */
        private String merchantType;
        /*** 最小拼团价（单位为元） */
        private String minGroupPrice;
        /***  最小单买价格（单位为元） */
        private String minNormalPrice;
        /***  快手专享 */
        private String onlySceneAuth;
        /***  商品标签ID */
        private String optId;
        /*** 商品标签id */
        private String optIds;
        /*** 商品标签名 */
        private String optName;
        /*** 推广计划类型 3:定向 4:招商 */
        private String planType;
        /*** 比价行为预判定佣金比例，百分比（需要用户备案） */
        private String predictPromotionRate;
        /*** 佣金比例，百分比 */
        private String promotionRate;
        /*** 已售卖件数 */
        private String salesTip;
        /*** 搜索id，建议生成推广链接时候填写，提高收益 */
        private String searchId;
        /*** 服务分 */
        private String servTxt;
        /*** 招商分成服务费比例，百分比 */
        private String shareRate;
        /*** 招商团长id */
        private String zsDuoId;
        /*** 商品类目列表 */
        private List<Categories> categories;
        /*** 商品品牌词信息，如“苹果”、“阿迪达斯”、“李宁”等（2021/10/11新增字段） */
        private String brandName;

        @Data
        private static class Categories {
            /*** 类目ID */
            private String id;
            /*** 类目名称 */
            private String name;
            /*** 类目级别(类目级别 0，1，2代表一、二、三级类目) */
            private String level;
            /*** 父级类目Id */
            private String parentId;
        }
    }
}
