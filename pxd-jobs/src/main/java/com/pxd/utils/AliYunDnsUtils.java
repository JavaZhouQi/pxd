package com.pxd.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.aliyun.alidns20150109.Client;
import com.aliyun.alidns20150109.models.*;
import com.aliyun.teaopenapi.models.Config;
import com.pxd.config.AliYunProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AliYunDnsUtils {
    /*** 公网ip获取url */
    private final static String ifConfigIpUrl = "https://ifconfig.co/ip";
    /*** 阿里云DNS访问的域名 */
    private final static String endpoint = "alidns.cn-shenzhen.aliyuncs.com";
    private static Client client;

    public AliYunDnsUtils(AliYunProperties aliYunProperties) {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(aliYunProperties.getAccessKeyId())
                // 您的AccessKey Secret
                .setAccessKeySecret(aliYunProperties.getAccessKeySecret());
        // 访问的域名
        config.setEndpoint(endpoint);
        try {
            client = new Client(config);
        } catch (Exception e) {
            log.error("AliYunDnsUtils init fail", e);
        }
    }

    /**
     * 获取公网ip
     */
    public static String getIp() {
        String ip = null;
        try {
            ip = HttpUtil.get(ifConfigIpUrl);
        } catch (Exception e) {
            log.error("获取ip异常", e);
        }
        return ip;
    }

    /**
     * 域名解析列表
     *
     * @param domainName
     * @return
     */
    public static List<DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord> domainRecords(String domainName) {
        DescribeDomainRecordsRequest describeDomainRecordsRequest = new DescribeDomainRecordsRequest();
        describeDomainRecordsRequest.setDomainName(domainName);
        DescribeDomainRecordsResponse describeDomainRecordsResponse;
        try {
            describeDomainRecordsResponse = client.describeDomainRecords(describeDomainRecordsRequest);
        } catch (Exception e) {
            log.error("调用域名解析列表查询错误", e);
            throw new RuntimeException("获取域名解析列表错误");
        }
        DescribeDomainRecordsResponseBody body = describeDomainRecordsResponse.getBody();
        return body.getDomainRecords().getRecord();
    }

    /**
     * 修改ip
     *
     * @param describeDomainRecordsResponseBodyDomainRecordsRecord
     * @param ip
     */
    public static void updateDomainIp(DescribeDomainRecordsResponseBody.DescribeDomainRecordsResponseBodyDomainRecordsRecord describeDomainRecordsResponseBodyDomainRecordsRecord, String ip) {
        UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest();
        updateDomainRecordRequest.setRecordId(describeDomainRecordsResponseBodyDomainRecordsRecord.getRecordId());
        updateDomainRecordRequest.setRR(describeDomainRecordsResponseBodyDomainRecordsRecord.getRR());
        updateDomainRecordRequest.setType(describeDomainRecordsResponseBodyDomainRecordsRecord.getType());
        updateDomainRecordRequest.setValue(ip);
        try {
            log.info("修改ip请求参数：{}", JSONUtil.toJsonStr(updateDomainRecordRequest));
            UpdateDomainRecordResponse updateDomainRecordResponse = client.updateDomainRecord(updateDomainRecordRequest);
            log.info("修改ip结果：{}", JSONUtil.toJsonStr(updateDomainRecordResponse));
        } catch (Exception e) {
            log.error("调用域名解析修改错误", e);
        }
    }

}
