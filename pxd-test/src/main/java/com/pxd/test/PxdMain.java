package com.pxd.test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import com.xyunchain.sdk.FpClient;
import com.xyunchain.sdk.bo.TradeOrderDetailsBO;
import com.xyunchain.sdk.bo.TradeOrderPaymentOrdersBO;
import com.xyunchain.sdk.config.AppConfig;
import com.xyunchain.sdk.enums.OrderChannelEnum;
import com.xyunchain.sdk.enums.TraderTypeEnum;
import com.xyunchain.sdk.req.UploadTradeOrderReq;
import com.xyunchain.sdk.result.Result;
import com.xyunchain.sdk.util.SignUtil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PxdMain {

    public static void main(String[] args) {
        // 1.设置配置参数
        AppConfig appConfig = AppConfig.init("http://127.0.0.1:9200/", "bobo", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFnTNa5WH26esZiD/PVVDyOUnf+A8PtgUsIl0WQl5VyrFHUo6y4Yfqw1cW8zx5tBsaeT6JxBWEzYaH2qvYTTDRnB2GfryJunoMwbobzVHR3l10tcKB8a9ewxEbwySamfNOFswt0YtiK37B9RQcqkhADKzT+NCd8gRzMvdUjqqWlQIDAQAB");
        // 2.初始化FpClient
        FpClient fpClient = new FpClient(appConfig);

        // 4.发送请求并获取结果
        ConcurrencyTester concurrencyTester = ThreadUtil.concurrencyTest(100, () -> {
            // 测试的逻辑内容
            try {
                // 3.构建请求体
                UploadTradeOrderReq uploadTradeOrderReq = new UploadTradeOrderReq();
                uploadTradeOrderReq.setMerchantCode(IdUtil.simpleUUID());
                uploadTradeOrderReq.setMerchantTradeNo("1");
                uploadTradeOrderReq.setTraderType(TraderTypeEnum.RECHARGE.name());
                uploadTradeOrderReq.setTradeTime("2021-12-21 10:00:00");
                uploadTradeOrderReq.setTradeTotalAmount(BigDecimal.ONE);
                uploadTradeOrderReq.setCustomerId("1");
                uploadTradeOrderReq.setCustomerPhoneNo("1");
                uploadTradeOrderReq.setTotalCount(1);
                uploadTradeOrderReq.setTerminalNumber(null);
                uploadTradeOrderReq.setChargeback(false);
                uploadTradeOrderReq.setTradeDetailList(new ArrayList<TradeOrderDetailsBO>() {{
                    TradeOrderDetailsBO tradeOrderDetailsBO = new TradeOrderDetailsBO();
                    tradeOrderDetailsBO.setDetailPrice(new BigDecimal("10"));
                    tradeOrderDetailsBO.setDetailCount(1);
                    tradeOrderDetailsBO.setDetailName("xxxx");
                    add(tradeOrderDetailsBO);
                }});
                uploadTradeOrderReq.setPaymentInfoList(new ArrayList<TradeOrderPaymentOrdersBO>() {{
                    TradeOrderPaymentOrdersBO tradeOrderPaymentOrdersBO = new TradeOrderPaymentOrdersBO();
                    tradeOrderPaymentOrdersBO.setPaymentNo("1");
                    tradeOrderPaymentOrdersBO.setPaymentChannel("ALIPAY_APP");
                    tradeOrderPaymentOrdersBO.setPaymentAmount(new BigDecimal("1"));
                    add(tradeOrderPaymentOrdersBO);
                }});
                uploadTradeOrderReq.setOrderChannel(OrderChannelEnum.OFFLINE.name());
                Result result = fpClient.uploadTradeOrder(uploadTradeOrderReq);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Console.log(concurrencyTester.getInterval());
    }

}
