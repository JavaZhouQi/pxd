package com.pxd.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import com.pxd.dto.goods.*;
import com.pxd.module.dtk.service.GoodsFactory;
import com.pxd.module.dtk.util.DtkUtil;
import com.pxd.service.GoodsService;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    /*** 热词缓存时间 */
    private final static int HOT_WORDS_TIME_OUT = 3600;
    private final static String GOODS_HOT_WORDS = "goods:hot:words";
    @Resource
    RedissonClient redissonClient;

    @Override
    public List<String> getHotWords() {
        // 优选查缓存
        RList<String> list = redissonClient.getList(GOODS_HOT_WORDS);
        if (CollectionUtil.isNotEmpty(list)) {
            // 随机取5个热词
            int start = RandomUtil.randomInt(0, list.size() - 6);
            return list.range(start, start + 5);
        }
        // 查询阿里云日志搜索词信息
        List<String> hotWords = DtkUtil.categoryHot();
        if (CollectionUtil.isEmpty(hotWords)) {
            // 没查询到热词信息泽抛出异常

        }
        // 添加到Redis缓存并设置超时时间
        list.addAll(hotWords);
        list.expire(Duration.ofSeconds(HOT_WORDS_TIME_OUT));
        // 随机取5个热词
        int start = RandomUtil.randomInt(0, list.size() - 6);
        return list.range(start, start + 5);
    }

    @Override
    public List<String> associationalWord(String text) {
        return DtkUtil.searchSuggestion(text);
    }

    @Override
    public SearchResp search(SearchReq searchReq) {
        return GoodsFactory.getGoodsImpl(searchReq.getPlatform()).search(searchReq);
    }

    @Override
    public DetailsResp details(String platform, String goodsId) {
        return GoodsFactory.getGoodsImpl(platform).details(goodsId);
    }

    @Override
    public TurnLinkResp turnLink(TurnLinkReq turnLinkReq) {
        return GoodsFactory.getGoodsImpl(turnLinkReq.getPlatform()).turnLink(turnLinkReq);
    }
}
