package com.pxd.module.tblm.entity;

import lombok.Data;

@Data
public class ConvertReq extends CommonReq {

    /*** Number	true	123	推广位id，mm_xx_xx_xx pid三段式中的第三段 */
    private Long adzone_id;
    /*** Number	false	123	淘客商品id */
    private Long item_id;
    /*** Number	false	1	1：PC，2：无线，默认：１ */
    private Integer platform;
    /*** String	false	12345	渠道管理ID */
    private String relation_id;
    /*** String	false	12345	会员运营ID*/
    private String special_id;
    /*** String	false	12345	淘宝客外部用户标记，如自身系统账户ID；微信ID等*/
    private String external_id;
    /*** String	false	abcdefg	团长与下游渠道合作的特殊标识，用于统计渠道推广效果 */
    private String xid;
    /*** Number	false	1	会员人群ID，用于统计人群推广效果*/
    private Long ucrowd_id;
    /*** Number	false	0	是否获取前N件佣金 ,0-否，1-是,其他值-否 */
    private Integer get_topn_rate;
    /*** Number	false	0	是否需要获取小程序链接，需要设置1。(暂未对外开放) */
    private Integer mini_program_link;

}
