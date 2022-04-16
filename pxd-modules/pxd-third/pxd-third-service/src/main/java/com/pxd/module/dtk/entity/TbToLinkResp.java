package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class TbToLinkResp extends DtkBaseReq {

    /*** 商品优惠券推广链接 */
    private String couponClickUrl;
    /*** 优惠券结束时间 */
    private String couponEndTime;
    /*** 优惠券面额 */
    private String couponInfo;
    /*** 优惠券开始时间*/
    private String couponStartTime;
    /*** 商品id */
    private String itemId;
    /*** 优惠券总量 */
    private String couponTotalCount;
    /*** 优惠券剩余量 */
    private String couponRemainCount;
    /*** 商品淘客链接 */
    private String itemUrl;
    /*** 淘口令 */
    private String tpwd;
    /*** 针对iOS14版本，增加对应能解析的长口令 */
    private String longTpwd;
    /*** 佣金比例 */
    private String maxCommissionRate;
    /*** 短链接 */
    private String shortUrl;
    /*** 当传入请求参数channelId、specialId、externalId时，该字段展示预估最低佣金率(%)(接联盟通知，官方比价订单佣金调整正式生效时间推迟至7月22日) */
    private String minCommissionRate;
    /*** 商品的快站链接（支持在微信端直接访问商品详情） 仅支持大淘客商品 */
    private String kuaiZhanUrl;
    /*** 商品原价(2020/12/30新增字段) */
    private String originalPrice;
    /*** 券后价(2020/12/30新增字段) */
    private String actualPrice;

}
