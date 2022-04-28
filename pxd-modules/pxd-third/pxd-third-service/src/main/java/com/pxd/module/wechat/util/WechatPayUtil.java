package com.pxd.module.wechat.util;

import cn.hutool.json.JSONUtil;
import com.pxd.module.im.enums.ChannelEnum;
import com.pxd.module.im.enums.WechatPayQueryTypeEnum;
import com.pxd.module.wechat.config.WechatPayProperties;
import com.pxd.module.wechat.constant.WechatPayHttpTypeEnum;
import com.pxd.module.wechat.constant.WechatUrlEnum;
import com.pxd.module.wechat.entity.*;
import com.pxd.module.wechat.exception.WechatException;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.exception.HttpCodeException;
import com.wechat.pay.contrib.apache.httpclient.exception.NotFoundException;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Objects;

@Slf4j
//@Component
public class WechatPayUtil {

    private static WechatPayProperties wechatPayProperties;
    private static CloseableHttpClient httpClient;

    public WechatPayUtil(WechatPayProperties wechatPayProperties) {
        WechatPayUtil.wechatPayProperties = wechatPayProperties;
        try {
            PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(
                    new ByteArrayInputStream(wechatPayProperties.getPrivateKey().getBytes(StandardCharsets.UTF_8)));
            CertificatesManager certificatesManager = CertificatesManager.getInstance();
            certificatesManager.putMerchant(wechatPayProperties.getMch_id(), new WechatPay2Credentials(wechatPayProperties.getMch_id(),
                    new PrivateKeySigner(wechatPayProperties.getSerialNumber(), merchantPrivateKey)), wechatPayProperties.getApiV3Key().getBytes(StandardCharsets.UTF_8));
            Verifier verifier = certificatesManager.getVerifier(wechatPayProperties.getMch_id());
            WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                    .withMerchant(wechatPayProperties.getMch_id(), wechatPayProperties.getSerialNumber(), merchantPrivateKey)
                    .withValidator(new WechatPay2Validator(verifier));
            httpClient = builder.build();
        } catch (Exception e) {
            throw new WechatException("初始化微信支付httpClient失败", e);
        }
    }

    /**
     * JSAPI下单
     *
     * @return
     */
    public static WechatTransactionsJsapiResp transactionsJsapi(WechatTransactionsJsapiEntity wechatTransactionsJsapiEntity) {
        String url = wechatPayProperties.getUrl() + WechatUrlEnum.TRANSACTIONS_JSAPI.getUrl();
        wechatTransactionsJsapiEntity.setAppid(wechatPayProperties.getAppid());
        wechatTransactionsJsapiEntity.setMchid(wechatPayProperties.getMch_id());
        wechatTransactionsJsapiEntity.setNotify_url(wechatPayProperties.getNotifyUrl() + ChannelEnum.WECHAT_NOTICE.getChannel());
        return httpSend(WechatPayHttpTypeEnum.HTTP_POST.getType(), url, wechatTransactionsJsapiEntity, WechatTransactionsJsapiResp.class);
    }

    /**
     * 查询订单
     */
    public static WechatTransactionsQueryResp transactionsQuery(int queryType, String orderId) {
        String url = null;
        if (Objects.equals(queryType, WechatPayQueryTypeEnum.WECHAT_ORDER.getType())) {
            url = wechatPayProperties.getUrl() + String.format(WechatUrlEnum.TRANSACTIONS_ID.getUrl(), orderId, wechatPayProperties.getMch_id());
        }
        if (Objects.equals(queryType, WechatPayQueryTypeEnum.MER_ORDER.getType())) {
            url = wechatPayProperties.getUrl() + String.format(WechatUrlEnum.TRANSACTIONS_OUT_TRADE_NO.getUrl(), orderId, wechatPayProperties.getMch_id());
        }
        return httpSend(WechatPayHttpTypeEnum.HTTP_GET.getType(), url, null, WechatTransactionsQueryResp.class);
    }

    /**
     * 关闭订单
     */
    public static WechatPayResp transactionsClose(String orderId) {
        String url = wechatPayProperties.getUrl() + String.format(WechatUrlEnum.TRANSACTIONS_CLOSE.getUrl(), orderId);
        WechatTransactionsReqEntity wechatTransactionsReqEntity = new WechatTransactionsJsapiEntity();
        wechatTransactionsReqEntity.setMchid(wechatPayProperties.getMch_id());
        return httpSend(WechatPayHttpTypeEnum.HTTP_POST.getType(), url, wechatTransactionsReqEntity, WechatPayResp.class);
    }

    /**
     * 申请退款
     */
    public static WechatTransactionsRefundsResp transactionsRefunds(WechatTransactionsRefundsEntity wechatTransactionsRefundsEntity) {
        wechatTransactionsRefundsEntity.setNotify_url(wechatPayProperties.getNotifyUrl() + ChannelEnum.WECHAT_NOTICE.getChannel());
        String url = wechatPayProperties.getUrl() + WechatUrlEnum.TRANSACTIONS_REFUNDS.getUrl();
        return httpSend(WechatPayHttpTypeEnum.HTTP_POST.getType(), url, wechatTransactionsRefundsEntity, WechatTransactionsRefundsResp.class);
    }

    /**
     * 查询单笔退款
     */
    public static WechatTransactionsRefundsResp transactionsRefundsQuery(String refundsOrderId) {
        String url = wechatPayProperties.getUrl() + String.format(WechatUrlEnum.TRANSACTIONS_REFUNDS_QUERY.getUrl(), refundsOrderId);
        return httpSend(WechatPayHttpTypeEnum.HTTP_GET.getType(), url, null, WechatTransactionsRefundsResp.class);
    }

    /**
     * 申请交易账单
     */
    public static WechatTransactionsRefundsResp tradeBill(WechatBillEntity tradeBill) {
        StringBuilder url = new StringBuilder(wechatPayProperties.getUrl() + WechatUrlEnum.TRADE_BILL.getUrl());
        url.append("?bill_date=").append(tradeBill.getBill_date());
        if (StringUtils.isNotBlank(tradeBill.getBill_type())) {
            url.append("&bill_type=").append(tradeBill.getBill_type());
        }
        if (StringUtils.isNotBlank(tradeBill.getTar_type())) {
            url.append("&tar_type=").append(tradeBill.getTar_type());
        }
        return httpSend(WechatPayHttpTypeEnum.HTTP_GET.getType(), url.toString(), null, WechatTransactionsRefundsResp.class);
    }

    /**
     * 申请资金账单
     */
    public static WechatTransactionsRefundsResp fundFlowBill(WechatBillEntity wechatBillEntity) {
        StringBuilder url = new StringBuilder(wechatPayProperties.getUrl() + WechatUrlEnum.FUND_FLOW_BILL_BILL.getUrl());
        url.append("?bill_date=").append(wechatBillEntity.getBill_date());
        if (StringUtils.isNotBlank(wechatBillEntity.getAccount_type())) {
            url.append("&account_type=").append(wechatBillEntity.getAccount_type());
        }
        if (StringUtils.isNotBlank(wechatBillEntity.getTar_type())) {
            url.append("&tar_type=").append(wechatBillEntity.getTar_type());
        }
        return httpSend(WechatPayHttpTypeEnum.HTTP_GET.getType(), url.toString(), null, WechatTransactionsRefundsResp.class);
    }


    private static <T> T httpSend(int method, String url, Object body, Class<T> tClass) {
        String req = null;
        HttpRequestBase httpRequestBase;
        switch (method) {
            case 1:
                httpRequestBase = new HttpGet(url);
                break;
            case 2:
                HttpPost httpPost = new HttpPost(url);
                if (body != null) {
                    httpPost.setEntity(new StringEntity(req = JSONUtil.toJsonStr(body), "UTF-8"));
                }
                httpRequestBase = httpPost;
                break;
            default:
                httpRequestBase = new HttpGet(url);
        }
        httpRequestBase.addHeader("Accept", "application/json");
        httpRequestBase.addHeader("Content-type", "application/json; charset=utf-8");
        String resp = null;
        try {
            log.info("[WechatPay]请求信息:URL:{},Body:{}", url, req);
            CloseableHttpResponse response = httpClient.execute(httpRequestBase);
            // 关闭订单状态码为204表示成功
            if (response.getStatusLine().getStatusCode() == 204) {
                log.info("[WechatPay]响应状态:STATUS:{}", response.getStatusLine().getStatusCode());
                return tClass.newInstance();
            }
            resp = EntityUtils.toString(response.getEntity());
            log.info("[WechatPay]响应信息:URL:{},Body:{}", url, resp);
        } catch (Exception e) {
            throw new WechatException("HTTP 调用异常", e);
        }
        return JSONUtil.toBean(resp, tClass);
    }

}
