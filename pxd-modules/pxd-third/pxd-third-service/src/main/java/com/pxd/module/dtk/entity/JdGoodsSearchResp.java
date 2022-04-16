package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class JdGoodsSearchResp {

    private String totalNum;
    private String pageId;
    private List<GoodsResp> list;

    @Data
    public static class GoodsResp {
        /*** 一级类目ID */
        private String cid1;
        /*** 一级类目名称 */
        private String cid1Name;
        /*** 二级类目ID */
        private String cid2;
        /*** 二级类目名称 */
        private String cid2Name;
        /*** 三级类目ID */
        private String cid3;
        /*** 三级类目名称 */
        private String cid3Name;
        /*** 评论数 */
        private String comments;
        /*** 佣金 */
        private String commission;
        /*** 佣金比例 */
        private String commissionShare;
        /*** 券后佣金，（促销价-优惠券面额）佣金比例 */
        private String couponCommission;
        /*** plus佣金比例，plus用户购买推广者能获取到的佣金比例 */
        private String plusCommissionShare;
        /*** 是否锁定佣金比例：1是，0否 */
        private String isLock;
        /*** 计划开始时间 */
        private String commissionStartTime;
        /*** 计划结束时间 */
        private String commissionEndTime;
        /*** 优惠券集合 */
        private List<Coupon> couponList;
        /*** 商品好评率 */
        private String goodCommentsShare;
        /*** 白底图 */
        private String whiteImage;
        /*** 图片合集 */
        private List<String> imageUrlList;
        /*** 30天引单数量 */
        private String inOrderCount30Days;
        /*** 商品落地页 */
        private String materialUrl;
        /*** 商品价格 */
        private String price;
        /*** 促销价 */
        private String lowestPrice;
        /*** 促销价类型，1：商品价格；2：拼购价格； 3：秒杀价格 */
        private String lowestPriceType;
        /*** 券后价（有无券都返回此字段，价格排序以此字段排序） */
        private String lowestCouponPrice;
        /***  店铺名称（或供应商名称） */
        private String shopName;
        /*** 商家Id */
        private String shopId;
        /*** 店铺等级 */
        private String shopLevel;
        /*** 1：京东好店 https://img12.360buyimg.com/schoolbt/jfs/t1/80828/19/2993/908/5d14277aEbb134d76/889d5265315e11ed.png */
        private String shopLabel;
        /*** 用户评价评分（仅pop店铺有值） */
        private String userEvaluateScore;
        /*** 用户评价评级（仅pop店铺有值） */
        private String commentFactorScoreRankGrade;
        /*** 物流履约评分（仅pop店铺有值） */
        private String logisticsLvyueScore;
        /*** 物流履约评级（仅pop店铺有值） */
        private String logisticsFactorScoreRankGrade;
        /*** 售后服务评分（仅pop店铺有值） */
        private String afterServiceScore;
        /*** 售后服务评级（仅pop店铺有值） */
        private String afsFactorScoreRankGrade;
        /*** 店铺风向标（仅pop店铺有值） */
        private String scoreRankRate;
        /*** 商品ID */
        private String skuId;
        /*** 商品名称 */
        private String skuName;
        /*** 其值为同款商品的主skuid */
        private String spuid;
        /*** 品牌code */
        private String brandCode;
        /*** 品牌名 */
        private String brandName;
        /*** g=自营，p=pop */
        private String owner;
        /*** 视频合集 */
        private List<String> videoList;
        /*** 评论合集 */
        private List<String> commentList;
        /*** 描述文案 */
        private String document;

        @Data
        private static class Coupon {
            /*** 券种类 (优惠券种类：0 - 全品类，1 - 限品类（自营商品），2 - 限店铺，3 - 店铺限商品券) */
            private String bindType;
            /*** 券面额 */
            private String discount;
            /*** 券链接 */
            private String link;
            /*** 券使用平台 (平台类型：0 - 全平台券，1 - 限平台券) */
            private String platformType;
            /*** 券消费限额 */
            private String quota;
            /*** 领取开始时间 */
            private String getStartTime;
            /*** 券领取结束时间 */
            private String getEndTime;
            /***  券有效使用开始时间 */
            private String useStartTime;
            /*** 券有效使用结束时间 */
            private String useEndTime;
            /*** 最优优惠券，1：是；0：否，购买一件商品可使用的面额最大优惠券 */
            private String isBest;
            /*** 券热度，值越大热度越高，区间:[0,10] */
            private String hotValue;
            /*** 入参couponUrl优惠券链接搜索对应的券，1 是 ，0 否 */
            private String isInputCoupon;
        }
    }
}
