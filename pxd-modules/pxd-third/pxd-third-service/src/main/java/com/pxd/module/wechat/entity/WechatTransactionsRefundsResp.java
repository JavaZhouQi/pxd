package com.pxd.module.wechat.entity;

import lombok.Data;

@Data
public class WechatTransactionsRefundsResp extends WechatPayResp {
    /**
     * 微信支付退款单号
     */
    private String refund_id;
    /**
     * 商户退款单号
     */
    private String out_refund_no;
    /**
     * 微信支付订单号
     */
    private String transaction_id;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 退款渠道
     * 枚举值：
     * ORIGINAL：原路退款
     * BALANCE：退回到余额
     * OTHER_BALANCE：原账户异常退到其他余额账户
     * OTHER_BANKCARD：原银行卡异常退到其他银行卡
     */
    private String channel;
    /**
     * 取当前退款单的退款入账方，有以下几种情况：
     * 1）退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:支付用户零钱
     * 3）退还商户:商户基本账户商户结算银行账户
     * 4）退回支付用户零钱通:支付用户零钱通
     */
    private String user_received_account;
    /**
     * 退款成功时间，当退款状态为退款成功时有返回。
     */
    private String success_time;
    /**
     * 退款受理时间
     */
    private String create_time;
    /**
     * 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台-交易中心，手动处理此笔退款。
     * 枚举值：
     * SUCCESS：退款成功
     * CLOSED：退款关闭
     * PROCESSING：退款处理中
     * ABNORMAL：退款异常
     */
    private String status;
    /**
     * 退款所使用资金对应的资金账户类型
     * 枚举值：
     * UNSETTLED : 未结算资金
     * AVAILABLE : 可用余额
     * UNAVAILABLE : 不可用余额
     * OPERATION : 运营户
     * BASIC : 基本账户（含可用余额和不可用余额）
     */
    private String funds_account;
    /**
     * 金额详细信息
     */
    private WechatAmountEntity amount;
    /**
     * 优惠退款信息
     */
    private String promotion_detail;
}
