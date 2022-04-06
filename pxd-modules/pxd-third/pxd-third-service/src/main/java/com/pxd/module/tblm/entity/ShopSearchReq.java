package com.pxd.module.tblm.entity;

import lombok.Data;

@Data
public class ShopSearchReq extends CommonReq {

    /*** String	true	user_id,shop_title,shop_type,seller_nick,pict_url,shop_url	需返回的字段列表 */
    private String fields = "user_id,shop_title,shop_type,seller_nick,pict_url,shop_url";
    /*** String	true	女装	查询词 */
    private String q;
    /*** String	false	commission_rate_des	排序_des（降序），排序_asc（升序），佣金比率（commission_rate）， 商品数量（auction_count），销售总数量（total_auction） */
    private String sort;
    /*** Boolean	false	false	是否商城的店铺，设置为true表示该是属于淘宝商城的店铺，设置为false或不设置表示不判断这个属性 */
    private Boolean is_tmall;
    /*** Number	false	1	信用等级下限，1~20 */
    private Integer start_credit;
    /*** Number	false	20	信用等级上限，1~20 */
    private Integer end_credit;
    /*** Number	false	2000	淘客佣金比率下限，1~10000 */
    private Integer start_commission_rate;
    /*** Number	false	123	淘客佣金比率上限，1~10000 */
    private Integer end_commission_rate;
    /*** Number	false	1	店铺商品总数下限 */
    private Integer start_total_action;
    /*** Number	false	100	店铺商品总数上限 */
    private Integer end_total_action;
    /*** Number	false	123	累计推广商品下限 */
    private Integer start_auction_count;
    /*** Number	false	200	累计推广商品上限 */
    private Integer end_auction_count;
    /*** Number	false	1	链接形式：1：PC，2：无线，默认：１ */
    private Integer platform;
    /*** Number	false	1	第几页，默认1，1~100 */
    private Integer page_no;
    /*** Number	false	20	页大小，默认20，1~100 */
    private Integer page_size;

}
