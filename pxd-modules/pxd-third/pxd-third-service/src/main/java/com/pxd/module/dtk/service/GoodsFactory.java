package com.pxd.module.dtk.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoodsFactory {

    private static final Map<String, GoodsImpl> map = new HashMap<>();

    public GoodsFactory(List<GoodsImpl> list) {
        for (GoodsImpl goods : list) {
            map.put(goods.getPlatform(), goods);
        }
    }

    public static GoodsImpl getGoodsImpl(String platform) {
        GoodsImpl goods = map.get(platform);
        if (goods == null) {
            throw new RuntimeException("获取GoodsImpl实例错误，platform：" + platform);
        }
        return map.get(platform);
    }

}
