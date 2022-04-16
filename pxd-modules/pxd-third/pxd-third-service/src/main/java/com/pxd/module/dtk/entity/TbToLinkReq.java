package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class TbToLinkReq extends DtkBaseReq {

    /*** 淘宝商品id */
    private String goodsId;
    /*** 商品的优惠券ID，一个商品在联盟可能有多个优惠券，可通过填写该参数的方式选择使用的优惠券，请确认优惠券ID正确，否则无法正常跳转  */
    private String couponId;
    /*** 推广位ID，用户可自由填写当前大淘客账号下已授权淘宝账号的任一pid，若未填写，则默认使用创建应用时绑定的pid  */
    private String pid;
    /*** 渠道id将会和传入的pid进行验证，验证通过将正常转链，请确认填入的渠道id是正确的 channelId对应联盟的relationId */
    private String channelId;
    /*** 付定返红包，0.不使用付定返红包，1.参与付定返红包 */
    private String rebateType;
    /*** 会员运营id */
    private String specialId;
    /*** 淘宝客外部用户标记，如自身系统账户ID；微信ID等  */
    private String externalId;
    /*** 团长与下游渠道合作的特殊标识，用于统计渠道推广效果 （新增入参） */
    private String xid;
    /*** 淘口令左边自定义符号,默认￥ （2021/3/9新增入参） */
    private String leftSymbol;
    /*** 淘口令右边自定义符号,默认￥ （2021/3/9新增入参） */
    private String rightSymbol;
    /*** 平台的淘宝授权id（获取地址：https://www.dataoke.com/shouquan?type=1&auth_id=1），如果传入了该参数则必须填写对应淘宝联盟授权账号的pid（1/21新增字段） */
    private String authId;

}
