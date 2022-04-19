package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class JdGoodsSearchReq extends DtkBaseReq {

    /*** 一级类目id */
    private String cid1;
    /*** 二级类目id */
    private String cid2;
    /*** 三级类目id */
    private String cid3;
    /*** 页码 */
    private String pageId = "1";
    /*** 每页数量，单页数最大30，默认20 */
    private String pageSize = "30";
    /*** skuid集合(一次最多支持查询100个sku)，多个使用“,”分隔符 */
    private String skuIds;
    /*** 关键词，字数同京东商品名称一致，目前未限制 */
    private String keyword;
    /*** 商品券后价格下限 */
    private String priceFrom;
    /*** 商品券后价格上限 */
    private String priceTo;
    /*** 佣金比例区间开始 */
    private String commissionShareStart;
    /*** 佣金比例区间结束 */
    private String commissionShareEnd;
    /*** 商品类型：自营[g]，POP[p] */
    private String owner;
    /*** 排序字段(price：单价, commissionShare：佣金比例, commission：佣金， inOrderCount30Days：30天引单量， inOrderComm30Days：30天支出佣金) */
    private String sortName;
    /*** asc：升序；desc：降序。默认降序 */
    private String sort;
    /*** 是否是优惠券商品，1：有优惠券，0：无优惠券 */
    private Integer isCoupon;
    /*** 拼购价格区间开始 */
    private String pingouPriceStart;
    /*** 拼购价格区间结束 */
    private String pingouPriceEnd;
    /*** 品牌code */
    private String brandCode;
    /*** 店铺Id */
    private String shopId;
    /*** 查询有最优惠券商品；其他值过滤掉此入参条件。（查询最优券需与isCoupon同时使用） */
    private String hasBestCoupon;
    /*** 联盟id_应用iD_推广位id */
    private String pid;
    /*** 京喜商品类型，1京喜、2京喜工厂直供、3京喜优选（包含3时可在京东APP购买），入参多个值表示或条件查询 */
    private String jxFlags;
    /*** 主商品spuId */
    private String spuId;
    /*** 优惠券链接 */
    private String couponUrl;
    /*** 京东配送 1：是，0：不是 */
    private String deliveryType;

}
