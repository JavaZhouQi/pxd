package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

import java.util.List;

@Data
public class WechatAmountEntity {
    /**
     * 订单总金额，单位为分。（必填）
     * 示例值：100
     */
    private Long total;
    /**
     * 货币类型（必填）
     * CNY：人民币，境内商户号仅支持人民币。
     */
    private String currency = "CNY";
    /**
     * 退款金额，单位为分，只能为整数，不能超过原订单支付金额。（必填）
     */
    private Long refund;
    /**
     * 退款需要从指定账户出资时，传递此参数指定出资金额（币种的最小单位，只能为整数）。
     * 同时指定多个账户出资退款的使用场景需要满足以下条件：
     * 1、未开通退款支出分离产品功能；
     * 2、订单属于分账订单，且分账处于待分账或分账中状态。
     * 参数传递需要满足条件：
     * 1、基本账户可用余额出资金额与基本账户不可用余额出资金额之和等于退款金额；
     * 2、账户类型不能重复。
     * 上述任一条件不满足将返回错误
     */
    private List<WechatPayFromEntity> from;
    /**
     * 现金支付金额，单位为分，只能为整数
     */
    private Long payer_total;
    /**
     * 退款给用户的金额，不包含所有优惠券金额
     */
    private Long payer_refund;
    /**
     * 去掉非充值代金券退款金额后的退款金额，单位为分，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    private Long settlement_refund;
    /**
     * 应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额，单位为分
     */
    private Long settlement_total;
    /**
     * 优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分
     */
    private Long discount_refund;

    public static WechatAmountEntity init(Long total) {
        WechatAmountEntity wechatAmountEntity = new WechatAmountEntity();
        wechatAmountEntity.setTotal(total);
        return wechatAmountEntity;
    }

    public static WechatAmountEntity init(Long total, Long refund) {
        WechatAmountEntity wechatAmountEntity = new WechatAmountEntity();
        wechatAmountEntity.setTotal(total);
        wechatAmountEntity.setRefund(refund);
        return wechatAmountEntity;
    }
}
