package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class PddToLinkResp {
    /*** 推广短链接 */
    private String mobileShortUrl;
    /*** 推广长连接 */
    private String mobileUrl;
    /*** 单人团推广短链接*/
    private String shortUrl;
    /*** */
    private String schemaUrl;
    /*** 单人团推广长连接 */
    private String url;
    /*** 商品ID */
    private String goodsId;
    /*** 商品名称 */
    private String goodsName;
    /*** 最小单买价格（单位为元）*/
    private String minNormalPrice;
    /*** 最小拼团价格（单位为元） */
    private String minGroupPrice;
    /*** 佣金比例，千分比 */
    private String promotionRate;
    /*** 比价行为预判定佣金，需要用户备案 */
    private String predictPromotionRate;
    /*** 是否有券(1为有券，0为无券） */
    private String hasCoupon;
    /*** 优惠券门槛价格，单位为元 */
    private String couponMinOrderAmount;
    /*** 优惠券面额，单位为元 */
    private String couponDiscount;
    /*** 优惠券总数 */
    private String couponTotalQuantity;
    /*** 剩余优惠券数量 */
    private String couponRemainQuantity;
    /*** */
    private String qqAppPagePath;
    /*** */
    private String weAppPagePath;
    /*** 优惠券生效时间 */
    private String couponStartTime;
    /*** 优惠券失效时间 */
    private String couponEndTime;
}
