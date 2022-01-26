package com.pxd.module.wechat.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xyunchain.common.redis.RedisUtil;
import com.xyunchain.third.module.wechat.config.*;
import com.xyunchain.third.module.wechat.constant.WechatRedisKeyConstant;
import com.xyunchain.third.module.wechat.constant.WechatUrlEnum;
import com.xyunchain.third.module.wechat.entity.*;
import com.xyunchain.third.module.wechat.exception.WechatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class WechatMiniUtil {

    private static RedisUtil redisUtil;
    private static WechatMiniProperties wechatProperties;

    @Autowired
    public WechatMiniUtil(RedisUtil redisUtil, WechatMiniProperties wechatProperties) {
        WechatMiniUtil.redisUtil = redisUtil;
        WechatMiniUtil.wechatProperties = wechatProperties;
    }

    /**
     * 获取AccessToken
     */
    public static String getAccessToken() {
        // TODO AccessToken后续需要区分测试，跟生产环境
        if (redisUtil.hasKey(WechatRedisKeyConstant.ACCESS_TOKEN)) {
            return (String) redisUtil.get(WechatRedisKeyConstant.ACCESS_TOKEN);
        }
        WechatAccessTokenEntity wechatAccessTokenEntity = httpGet(String.format(WechatUrlEnum.ACCESS_TOKEN.getUrl(), wechatProperties.getAppid(), wechatProperties.getSecret()), WechatAccessTokenEntity.class);
        System.out.println(JSONUtil.toJsonStr(wechatAccessTokenEntity));
        if (!wechatAccessTokenEntity.isSuccess()) {
            throw new WechatException("获取AccessToken异常,信息：" + wechatAccessTokenEntity.getErrmsg());
        }
        redisUtil.set(WechatRedisKeyConstant.ACCESS_TOKEN, wechatAccessTokenEntity.getAccess_token(), wechatAccessTokenEntity.getExpires_in() - 5);
        return wechatAccessTokenEntity.getAccess_token();
    }

    /**
     * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
     */
    public static WechatJsCode2SessionEntity jsCode2Session(String jsCode) {
        return httpGet(String.format(WechatUrlEnum.CODE_2_SESSION.getUrl(), wechatProperties.getAppid(), wechatProperties.getSecret(), jsCode), WechatJsCode2SessionEntity.class);
    }

    /**
     * 检查加密信息是否由微信生成（当前只支持手机号加密数据）
     *
     * @param encryptedMsgHash 加密数据的sha256，通过Hex（Base16）编码后的字符串
     * @return
     */
    public static WechatCheckEncryptedMsgEntity checkEncryptedMsg(String encryptedMsgHash) {
        JSONObject jsonObject = JSONUtil.createObj();
        jsonObject.set("encrypted_msg_hash", encryptedMsgHash);
        return httpPost(String.format(WechatUrlEnum.CHECK_ENCRYPTED_MSG.getUrl(), getAccessToken()), jsonObject.toString(), WechatCheckEncryptedMsgEntity.class);
    }

    /**
     * 获取用户手机号
     *
     * @param code 手机号获取凭证
     * @return
     */
    public static WechatUserPhoneEntity getUserPhoneNumber(String code) {
        JSONObject jsonObject = JSONUtil.createObj();
        jsonObject.set("code", code);
        return httpPost(String.format(WechatUrlEnum.USER_PHONE.getUrl(), getAccessToken()), jsonObject.toString(), WechatUserPhoneEntity.class);
    }

    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
     *
     * @param unLimitQrEntity 验证码生成信息
     * @return
     */
    public static String getUnLimitQr(WechatUnLimitQrEntity unLimitQrEntity) {
        String body = JSONUtil.toJsonStr(unLimitQrEntity);
        log.info("[WeChat]请求信息:URL:{},BODY:{}", WechatUrlEnum.UNLIMITED.getUrl(), body);
        HttpResponse execute = HttpRequest.post(String.format(WechatUrlEnum.UNLIMITED.getUrl(), getAccessToken())).body(body).execute();
        if (Objects.equals(ContentType.parse(execute.header("Content-Type")).getMimeType(), ContentType.APPLICATION_JSON.getMimeType())) {
            String resp = execute.body();
            log.error("[WeChat]生成二维码异常:{}", resp);
            WechatErrorEntity wechatErrorEntity = JSONUtil.toBean(resp, WechatErrorEntity.class);
            throw new WechatException("生成二维码异常,信息：" + wechatErrorEntity.getErrmsg());
        }
        return Base64.encode(execute.bodyBytes());
    }

    /**
     * 发起 http get 请求
     */
    private static <T> T httpGet(String url, Class<T> tClass) {
        log.info("[WeChat]请求信息:{}", url);
        String result = HttpUtil.get(url);
        log.info("[WeChat]响应信息:{}", result);
        return JSONUtil.toBean(result, tClass);
    }

    /**
     * 发起 http post 请求
     */
    private static <T> T httpPost(String url, String body, Class<T> tClass) {
        log.info("[WeChat]请求信息:URL:{},BODY:{}", url, body);
        String result = HttpUtil.post(url, body);
        log.info("[WeChat]响应信息:{}", result);
        if (Objects.equals(tClass, String.class)) {
            return (T) result;
        }
        return JSONUtil.toBean(result, tClass);
    }
}
