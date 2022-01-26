package com.pxd.module.wechat.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WechatUrlEnum {
    /**
     * 小程序相关接口
     */
    ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", "获取接口调用凭据"),
    CODE_2_SESSION("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", "登录凭证校验"),
    CHECK_ENCRYPTED_MSG("https://api.weixin.qq.com/wxa/business/checkencryptedmsg?access_token=%s", "检查加密信息是否由微信生成（当前只支持手机号加密数据）"),
    USER_PHONE("https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=%s", "获取用户手机号"),
    UNLIMITED("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s", "获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制"),
    /**
     * 微信支付相关接口
     */
    TRANSACTIONS_JSAPI("/v3/pay/transactions/jsapi", "JSAPI下单"),
    TRANSACTIONS_ID("/v3/pay/transactions/id/%s?mchid=%s", "微信单号查询"),
    TRANSACTIONS_OUT_TRADE_NO("/v3/pay/transactions/out-trade-no/%s?mchid=%s", "商户订单号查询"),
    TRANSACTIONS_CLOSE("/v3/pay/transactions/out-trade-no/%s/close", "关闭订单"),
    TRANSACTIONS_REFUNDS("/v3/refund/domestic/refunds", "申请退款API"),
    TRANSACTIONS_REFUNDS_QUERY("/v3/refund/domestic/refunds/%s", "查询单笔退款"),
    TRADE_BILL("/v3/bill/tradebill","申请交易账单"),
    FUND_FLOW_BILL_BILL("/v3/bill/fundflowbill","申请交易账单"),

    ;

    private String url;
    private String desc;
}
