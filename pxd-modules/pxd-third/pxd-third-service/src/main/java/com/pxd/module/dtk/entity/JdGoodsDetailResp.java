package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class JdGoodsDetailResp extends DtkBaseReq {
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
    /*** 商品ID */
    private String skuId;
    /*** 商品名称 */
    private String skuName;
    /*** 商品原价 */
    private String originPrice;
    /*** 商品券后价 */
    private String actualPrice;
    /*** 商品主图 */
    private String picMain;
    /*** 商品小图 */
    private List<String> smallImages;
    /*** 商品详情图 */
    private List<String> detailImages;
    /*** 商品落地页 */
    private String materialUrl;
    /*** 是否支持运费险(1:是,0:否) */
    private String isFreeFreightRisk;
    /*** 是否包邮(1:是,0:否,2:自营商品遵从主站包邮规则) */
    private String isFreeShipping;
    /*** 是否旗舰店(1:是,0:否) */
    private String isFlagship;
    /*** 是否秒杀(1:是,0:否) */
    private String isSeckill;
    /*** 30天引单数量 */
    private String inOrderCount30Days;
    /*** 是否自营(1:是,0:否) */
    private String isOwner;
    /*** 评论数 */
    private String comments;
    /*** 商品好评率 */
    private String goodsCommentShare;
    /*** 店铺ID */
    private String shopId;
    /*** 店铺名称 */
    private String shopName;
    /*** 佣金 */
    private String commission;
    /*** 佣金比例 */
    private String commissionShare;
    /*** 计划开始时间 */
    private String commissionStartTime;
    /*** 计划结束时间 */
    private String commissionEndTime;
    /*** 优惠券类型 */
    private String couponType;
    /*** 优惠券链接 */
    private String couponLink;
    /*** 优惠券金额 */
    private String couponAmount;
    /*** 优惠券使用条件 */
    private String couponConditions;
    /*** 优惠券生效时间 */
    private String couponStartTime;
    /*** 优惠券失效时间 */
    private String couponEndTime;
    /*** 券有效使用开始时间 */
    private String couponUseStartTime;
    /*** 券有效使用结束时间 */
    private String couponUserEndTime;
    /*** 优惠券总数 */
    private String couponTotalCount;
    /*** 优惠券剩余数 */
    private String couponRemainCount;
    /*** 优惠券领取数 */
    private String couponReceiveCount;
    /*** 商品推荐文案 */
    private String extensionContent;
    /*** 星罗商品百科信息 */
    private String productIntro;
    /*** plus佣金比例，plus用户购买推广者能获取到的佣金比例（7/20新增字段） */
    private String plusCommissionShare;
    /*** 是否30天历史最低价，0-否；1-是（8/24新增字段） */
    private String lowest;
}
