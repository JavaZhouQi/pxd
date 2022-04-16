package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsDetailResp {

    /*** 类目ID */
    private String categoryId ;
    /*** 类目名称 */
    private String categoryName ;
    /*** 商品轮播图 */
    private List<String> goodsGalleryUrls ;
    /*** 商品ID */
    private String goodsId ;
    /*** 商品类目id */
    private String catIds ;
    /*** 优惠券面额，单位为元 */
    private String couponDiscount ;
    /*** 优惠券失效时间 */
    private String couponEndTime ;
    /*** 优惠券门槛价格，单位为元 */
    private String couponMinOrderAmount ;
    /*** 优惠券剩余数量 */
    private String couponRemainQuantity ;
    /*** 优惠券生效时间 */
    private String couponStartTime ;
    /*** 优惠券总数量 */
    private String couponTotalQuantity ;
    /*** 描述分 */
    private String descTxt ;
    /*** 商品描述 */
    private String goodsDesc  ;
    /*** 商品主图 */
    private String goodsImageUrl ;
    /*** 商品名称 */
    private String goodsName ;
    /*** 商品goodsSign，支持通过goodsSign查询商品。goodsSign是加密后的goodsId, goodsId已下线，请使用goodsSign来替代。使用说明：https://jinbao.pinduoduo.com/qa-system?questionId=252 */
    private String goodsSign ;
    /*** 商品缩略图 */
    private String goodsThumbnailUrl ;
    /*** 商品是否有优惠券 1-有，0-没有 */
    private String hasCoupon ;
    /*** 是否有店铺券 1-有，0-没有 */
    private String hasMallCoupon ;
    /*** 物流分 */
    private String lgstTxt ;
    /*** 店铺券折扣 */
    private String mallCouponDiscountPct  ;
    /*** 店铺券结束使用时间 */
    private String mallCouponEndTime ;
    /*** 最大使用金额 */
    private String mallCouponMaxDiscountAmount ;
    /*** 最小使用金额 */
    private String mallCouponMinOrderAmount ;
    /*** 店铺券余量 */
    private String mallCouponRemainQuantity ;
    /*** 店铺券开始使用时间 */
    private String mallCouponStartTime ;
    /*** 店铺券总量 */
    private String mallCouponTotalQuantity ;
    /*** 该商品所在店铺是否参与全店推广，0：否，1：是 */
    private String mallCps ;
    /*** 店铺id */
    private String mallId;
    /*** 店铺名字 */
    private String mallName;
    /*** 店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店 */
    private String merchantType;
    /*** 最小拼团价（单位为元）*/
    private String minGroupPrice;
    /*** 最小单买价格（单位为元） */
    private String minNormalPrice;
    /*** 快手专享 */
    private String onlySceneAuth;
    /*** 商品标签ID */
    private String optId;
    /*** 商品标签id */
    private List<String> optIds;
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
    /*** 服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,1可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装 */
    private List<String>  serviceTags;
    /*** 服务分 */
    private String servTxt;
    /*** 招商分成服务费比例，百分比 */
    private String shareRate;
    /*** 优惠标签列表，包括： */
    private List<String>  unifiedTags;
    /*** 商品视频url */
    private String videoUrls;
    /***  招商团长id */
    private String zsDuoId;
    /*** 是否30天历史最低价，0-否；1-是 */
    private String lowest;
    /*** 销量模糊数据（1/21新增字段） */
    private String salesTipFuzz;

}
