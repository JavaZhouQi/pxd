package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class ListSuperGoodsReq extends DtkBaseReq {

    /*** 搜索类型：0-综合结果，1-大淘客商品，2-联盟商品 */
    private Integer type = 0;
    /*** 请求的页码，默认参数1 */
    private Long pageId = 1L;
    /*** 每页条数，默认为20，最大值100 */
    private Long pageSize = 10L;
    /*** 关键词搜索 */
    private String keyWords;
    /*** 是否天猫商品：1-天猫商品，0-所有商品，不填默认为0 */
    private String tmall;
    /*** 是否海淘商品：1-海淘商品，0-所有商品，不填默认为0 */
    private String haitao;
    /*** 排序字段信息 销量（total_sales） 价格（price），排序_des（降序），排序_asc（升序），示例：升序查询销量total_sales_asc 新增排序字段和排序方式，默认为0，0-综合排序，1-销量从高到低，2-销量从低到高，3-佣金比例从低到高，4-佣金比例从高到低，5-价格从高到低，6-价格从低到高(2021/1/15新增字段，之前的排序方式也可以使用) */
    private String sort;
    /*** 会员运营id */
    private String specialId;
    /***  渠道id将会和传入的pid进行验证，验证通过将正常转链，请确认填入的渠道id是正确的channelId对应联盟的relationId */
    private String channelId;
    /*** 商品券后价下限(2021/1/15新增字段) */
    private String priceLowerLimit;
    /*** 商品券后价上限(2021/1/15新增字段) */
    private String priceUpperLimit;
    /*** 淘客佣金比率上限(2021/1/15新增字段) */
    private String endTkRate;
    /*** 淘客佣金比率下限(2021/1/15新增字段) */
    private String startTkRate;
    /*** 是否有券，1为有券，默认为全部(2021/1/15新增字段) */
    private String hasCoupon;
    /*** 活动id，多个使用,分隔符。示例1,2,3（12/7新增字段） */
    private String activityId;
    /*** 商品是否已经验货，0-否；1-是（1/26新增字段） */
    private String inspectedGoods;

}
