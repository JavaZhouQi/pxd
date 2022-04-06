package com.pxd.module.tblm.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pxd.module.tblm.config.TblmConfig;
import com.pxd.module.tblm.entity.CommonReq;
import com.pxd.module.tblm.entity.ConvertReq;
import com.pxd.module.tblm.entity.ShopSearchReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Component
public class TblmUtil {

    /*** 超时时间 */
    private final static int TIMEOUT = 3000;
    private static TblmConfig tblmConfig;

    public TblmUtil(TblmConfig tblmConfig) {
        TblmUtil.tblmConfig = tblmConfig;
    }

    public static void main(String[] args) {
        TblmUtil.tblmConfig = new TblmConfig();
        //shopSearch();
        convert();
    }

    public static void convert() {
        ConvertReq convertReq = new ConvertReq();
        convertReq.setAdzone_id(111963800235L);
        convertReq.setItem_id(669568470113L);
        convertReq.setMethod("taobao.tbk.coupon.convert");
        send(convertReq, Object.class);
    }

    /**
     * 店铺搜索
     */
    public static void shopSearch() {
        ShopSearchReq pidCheckReq = new ShopSearchReq();
        pidCheckReq.setQ("男装");
        pidCheckReq.setMethod("taobao.tbk.shop.get");
        send(pidCheckReq, Object.class);
    }

    /**
     * 请求
     */
    public static <T> T send(CommonReq req, Class<T> tClass) {
        req.setApp_key(tblmConfig.getAppKey());
        req.setTimestamp(DateUtil.now());
        TreeMap<String, Object> treeMap = BeanUtil.toBean(req, TreeMap.class);
        treeMap.put("sign", md5(treeMap));
        log.info("[淘宝联盟]请求参数：{}", treeMap);
        String post = HttpUtil.post(tblmConfig.getUrl(), treeMap, TIMEOUT);
        log.info("[淘宝联盟]响应参数：{}", post);
        return JSONUtil.toBean(post, tClass);
    }

    /**
     * 淘宝联盟md5签名
     */
    public static String md5(TreeMap<String, Object> treeMap) {
        StringBuilder sb = new StringBuilder();
        sb.append(tblmConfig.getAppSecret());
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            if (StringUtils.isNotBlank(entry.getKey()) && entry.getValue() != null) {
                sb.append(entry.getKey()).append(entry.getValue());
            }
        }
        sb.append(tblmConfig.getAppSecret());
        return SecureUtil.md5(sb.toString()).toUpperCase(Locale.ROOT);
    }
}
