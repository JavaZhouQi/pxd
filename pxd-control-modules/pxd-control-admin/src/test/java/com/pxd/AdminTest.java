package com.pxd;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pxd.common.constant.RedisKeyConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AdminTest {
    @Resource
    RedissonClient redissonClient;

    @Test
    public void get() {
        RBucket<String> bucket = redissonClient.getBucket(RedisKeyConstant.ADMIN_VERIFICATION_IMAGE + "00fd7fa2847a42c6a9f3b795460a9708");
        System.out.println(bucket.get());
    }

    public static void main(String[] args) throws Exception {
//        Config config = new Config()
//                // 您的AccessKey ID
//                .setAccessKeyId("LTAI5tHJGauTYh2APfQu5BNc")
//                // 您的AccessKey Secret
//                .setAccessKeySecret("UNFfVUeYvsB2MuqcHv0rEps7hnHDMo");
//        // 访问的域名
//        config.endpoint = "alidns.cn-shenzhen.aliyuncs.com";
//        Client client = new Client(config);
//        AddDomainRecordRequest addDomainRecordRequest = new AddDomainRecordRequest();
//        addDomainRecordRequest.setDomainName("pixiaodan.cn");
//        addDomainRecordRequest.setRR("a");
//        addDomainRecordRequest.setType("A");
//        addDomainRecordRequest.setValue("127.0.0.1");
//        // 复制代码运行请自行打印 API 的返回值
//        AddDomainRecordResponse addDomainRecordResponse = client.addDomainRecord(addDomainRecordRequest);
//        System.out.println(JSONUtil.toJsonStr(addDomainRecordResponse));

//        System.out.println(JSONUtil.toJsonPrettyStr(describeDomainRecordsResponse));
        System.out.println(HttpUtil.get("https://ifconfig.co/ip"));

    }
}
