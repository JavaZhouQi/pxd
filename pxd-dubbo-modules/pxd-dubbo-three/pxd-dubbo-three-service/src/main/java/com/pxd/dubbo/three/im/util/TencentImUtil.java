package com.pxd.dubbo.three.im.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.pxd.dubbo.three.im.config.TencentImConfig;
import com.pxd.dubbo.three.im.enums.ImUriEnum;
import com.tencentyun.TLSSigAPIv2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TencentImUtil {

    private static final String REDIS_KEY_TENCENT_IM_USER_ID_SIG = "tencent:im:userId:sig:";

    private static TencentImConfig tencentImConfig;
    private static RedissonClient redissonClient;
    private static Gson gson;

    @Autowired
    public TencentImUtil(TencentImConfig tencentImConfig, RedissonClient redissonClient, Gson gson) {
        TencentImUtil.tencentImConfig = tencentImConfig;
        TencentImUtil.redissonClient = redissonClient;
        TencentImUtil.gson = gson;
    }

    /**
     * 获取用户签名
     */
    public static String getUserSig(final String userId) {
        RBucket<String> bucket = redissonClient.getBucket(REDIS_KEY_TENCENT_IM_USER_ID_SIG + userId);
        if (StringUtils.isNotBlank(bucket.get())) {
            return bucket.get();
        }
        TLSSigAPIv2 tlsSigApi = new TLSSigAPIv2(tencentImConfig.getSdkappid(), tencentImConfig.getKey());
        String sig = tlsSigApi.genUserSig(userId, tencentImConfig.getExpire());
        // 减10秒进行容错
        bucket.set(sig, tencentImConfig.getExpire() - 10L, TimeUnit.SECONDS);
        return sig;
    }

    /**
     * 获取管理员用户签名
     */
    private static String getAdministratorSig() {
        return getUserSig(tencentImConfig.getAdministratorUserId());
    }

    /**
     * 获取腾讯im请求路径
     */
    private static String getHttpsUrl(final String imServiceApi) {
        return String.format("%s%s?sdkappid=%s&identifier=%s&usersig=%s&random=%s&contenttype=json",
                tencentImConfig.getUrl(), imServiceApi, tencentImConfig.getSdkappid(), tencentImConfig.getAdministratorUserId(), getAdministratorSig(), RandomUtil.randomInt(1000000));
    }

    /**
     * 发送IM相关请求
     */
    public static <T> T send(ImUriEnum imUriEnum, Object req, Class<T> tClass) {
        String httpsUrl = getHttpsUrl(imUriEnum.getValue());
        String jsonReq = req != null ? gson.toJson(req) : "{}";
        log.info("[腾讯IM]请求URL:[{}],参数:{}", httpsUrl, jsonReq);
        String result = HttpUtil.post(httpsUrl, jsonReq);
        log.info("[腾讯IM]响应结果：[{}]", result);
        return gson.fromJson(result, tClass);
    }
}
