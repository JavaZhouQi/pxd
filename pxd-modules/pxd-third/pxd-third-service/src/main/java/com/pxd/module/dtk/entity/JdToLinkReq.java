package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class JdToLinkReq extends DtkBaseReq {
    /*** 推客的联盟ID */
    private String unionId;
    /*** 推广物料url，例如活动链接、商品链接等；不支持仅传入skuid */
    private String materialId;
    /*** 新增推广位id （若无subUnionId权限，可入参该参数用来确定不同用户下单情况） */
    private String positionId;
    /*** 联盟子推客身份标识（不能传入接口调用者自己的pid） */
    private String childPid;
    /*** 子渠道标识，您可自定义传入字母、数字或下划线，最多支持80个字符，该参数会在订单行查询接口中展示，需要有权限才可使用  */
    private String subUnionId;
    /*** 优惠券领取链接，在使用优惠券、商品二合一功能时入参，且materialId须为商品详情页链接（5.27更新：若不填则会自动匹配上全额最大的优惠券进行转链） */
    private String couponUrl;
    /*** 转链类型，默认短链，短链有效期60天1：长链2：短链 3：长链+短链，*/
    private String chainType;
    /*** 礼金批次号 */
    private String giftCouponKey;
}
