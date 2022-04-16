package com.pxd.module.dtk.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pxd.module.dtk.config.DtkInfoConfig;
import com.pxd.module.dtk.entity.*;
import com.pxd.module.dtk.enums.DtkUriEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DtkUtil {

    /*** 调用超时时间 */
    private final static int TIMEOUT = 3000;
    /*** 热词data中的key */
    private final static String  HOT_WORDS = "hotWords";

    private static DtkInfoConfig dtkConfig;

    public DtkUtil(DtkInfoConfig dtkConfig) {
        DtkUtil.dtkConfig = dtkConfig;
    }

    /**
     * 京东联盟搜索
     */
    public static JdGoodsSearchResp jdGoodsSearch(JdGoodsSearchReq jdGoodsSearchReq) {
        String resp = send(DtkUriEnum.JD_GOODS_SEARCH, jdGoodsSearchReq);
        return JSONUtil.toBean(resp, JdGoodsSearchResp.class);
    }

    /**
     * 拼多多联盟搜索
     */
    public static PddGoodsSearchResp pddGoodsSearch(PddGoodsSearchReq pddGoodsSearchReq) {
        String resp = send(DtkUriEnum.PDD_GOODS_SEARCH, pddGoodsSearchReq);
        return JSONUtil.toBean(resp, PddGoodsSearchResp.class);
    }

    /**
     * 大淘客搜索
     */
    public static ListSuperGoodsResp listSuperGoods(ListSuperGoodsReq listSuperGoodsReq) {
        String resp = send(DtkUriEnum.LIST_SUPER_GOODS, listSuperGoodsReq);
        return JSONUtil.toBean(resp, ListSuperGoodsResp.class);
    }

    /**
     * 热搜记录（热搜词）
     */
    public static List<String> categoryHot() {
        String resp = send(DtkUriEnum.CATEGORY_HOT, new DtkBaseReq());
        return JSONUtil.parse(resp).getByPath(HOT_WORDS, List.class);
    }

    /**
     * 拼多多商品详情
     */
    public static PddGoodsDetailResp pddGoodsDetail(PddGoodsDetailReq pddGoodsDetailReq) {
        String resp = send(DtkUriEnum.PDD_GOODS_DETAIL, pddGoodsDetailReq);
        return JSONUtil.toBean(resp, PddGoodsDetailResp.class);
    }

    /**
     * 淘宝商品详情
     */
    public static TbGoodsDetailResp tbGoodsDetail(TbGoodsDetailReq tbGoodsDetailReq) {
        String resp = send(DtkUriEnum.TB_GOODS_DETAIL, tbGoodsDetailReq);
        return JSONUtil.toBean(resp, TbGoodsDetailResp.class);
    }

    /**
     * 京东商品详情
     */
    public static List<JdGoodsDetailResp> jdGoodsDetail(JdGoodsDetailReq jdGoodsDetailReq) {
        String resp = send(DtkUriEnum.JD_GOODS_DETAIL, jdGoodsDetailReq);
        return JSONUtil.toList(resp, JdGoodsDetailResp.class);
    }

    /**
     * 淘宝高效转链
     */
    public static TbToLinkResp tbToLink(TbToLinkReq tbToLinkReq) {
        String resp = send(DtkUriEnum.TB_TO_LINK, tbToLinkReq);
        return JSONUtil.toBean(resp, TbToLinkResp.class);
    }

    /**
     * 京东商品转链
     */
    public static JdToLinkResp jdToLink(JdToLinkReq jdToLinkReq) {
        String resp = send(DtkUriEnum.JD_TO_LINK, jdToLinkReq);
        return JSONUtil.toBean(resp, JdToLinkResp.class);
    }

    /**
     * 拼多多商品转链
     */
    public static PddToLinkResp pddToLink(PddToLinkReq pddToLinkReq) {
        String resp = send(DtkUriEnum.PDD_TO_LINK, pddToLinkReq);
        return JSONUtil.toBean(resp, PddToLinkResp.class);
    }

    /**
     * 联想词
     */
    public static List<String> searchSuggestion(String keyWords) {
        SearchSuggestionReq searchSuggestionReq = new SearchSuggestionReq();
        searchSuggestionReq.setKeyWords(keyWords);
        String resp = send(DtkUriEnum.SEARCH_SUGGESTION, searchSuggestionReq);
        List<SearchSuggestionResp> searchSuggestionRespList = JSONUtil.toList(resp, SearchSuggestionResp.class);
        return searchSuggestionRespList.stream().map(SearchSuggestionResp::getKw).collect(Collectors.toList());
    }

    /**
     * 拼多多商品转链
     */
    public static CommentListResp commentList(CommentListReq commentListReq) {
        String resp = send(DtkUriEnum.COMMENT_LIST, commentListReq);
        return JSONUtil.toBean(resp, CommentListResp.class);
    }

    /**
     * 请求
     */
    private static String send(DtkUriEnum dtkUriEnum, DtkBaseReq dtkBaseReq) {
        String uid = IdUtil.randomUUID();
        dtkBaseReq.setAppKey(dtkConfig.getAppKey());
        dtkBaseReq.setVersion(dtkUriEnum.getVersion());
        log.info("[大淘客]请求参数:ID:{},URI{},PARM:{}", uid, dtkUriEnum.getUri(), JSONUtil.toJsonStr(dtkBaseReq));
        String respStr = HttpUtil.get(dtkConfig.getUrl() + dtkUriEnum.getUri(), setSignToMap(dtkBaseReq), TIMEOUT);
        DtkBaseResp dtkBaseResp = JSONUtil.toBean(respStr, DtkBaseResp.class);
        System.out.println(respStr);
        boolean success = DtkBaseResp.isSuccess(dtkBaseResp);
        log.info("[大淘客]响应结果:ID:{},IS_SUCCESS:{},MSG:{}", uid, success, dtkBaseResp.getMsg());
        if (success) {
            return dtkBaseResp.getData();
        }
        return null;
    }

    /**
     * 转换成TreeMap并生成签名
     */
    private static TreeMap<String, Object> setSignToMap(DtkBaseReq dtkBaseReq) {
        TreeMap<String, Object> treeMap = BeanUtil.toBean(dtkBaseReq, TreeMap.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            if (entry.getValue() != null) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        stringBuilder.append("key=").append(dtkConfig.getAppSecret());
        treeMap.put("sign", SecureUtil.md5(stringBuilder.toString()).toUpperCase(Locale.ROOT));
        return treeMap;
    }


    public static void main(String[] args) {
        DtkUtil.dtkConfig = new DtkInfoConfig();

//        CommentListReq commentListReq = new CommentListReq();
//        commentListReq.setGoodsId("555563181860");
//        CommentListResp commentListResp = commentList(commentListReq);
//        System.out.println(commentListResp);

//        System.out.println(searchSuggestion("手机"));

//        PddToLinkReq pddToLinkReq = new PddToLinkReq();
//        pddToLinkReq.setPid("10787417_245588117");
//        pddToLinkReq.setGoodsSign("E972nbH2uzxHeKNxwfjaxt_4E1p6qm4VSA_JQ7TQgd4mv");
//        System.out.println(pddToLink(pddToLinkReq));

//        TbToLinkReq tbToLinkReq = new TbToLinkReq();
//        tbToLinkReq.setGoodsId("641646674941");
//        tbToLinkReq.setPid("mm_2469990045_2608900239_111963800235");
//        TbToLinkResp tbToLinkResp = tbToLink(tbToLinkReq);
//        System.out.println(tbToLinkResp);

//        JdGoodsSearchReq jdGoodsSearchReq = new JdGoodsSearchReq();
//        jdGoodsSearchReq.setKeyword("3080ti");
//        JdGoodsSearchResp jdGoodsSearchResp = jdGoodsSearch(jdGoodsSearchReq);
//        System.out.println(jdGoodsSearchResp);

//        PddGoodsSearchReq pddGoodsSearchReq = new PddGoodsSearchReq();
//        pddGoodsSearchReq.setKeyword("3080ti");
//        PddGoodsSearchResp pddGoodsSearch = pddGoodsSearch(pddGoodsSearchReq);
//        System.out.println(pddGoodsSearch);

//        ListSuperGoodsReq listSuperGoodsReq = new ListSuperGoodsReq();
//        listSuperGoodsReq.setKeyWords("牙膏");
//        ListSuperGoodsResp listSuperGoodsResp = listSuperGoods(listSuperGoodsReq);
//        System.out.println(listSuperGoodsResp);

//        List<String> strings = categoryHot();
//        System.out.println(strings);

//        PddGoodsDetailReq pddGoodsDetailReq = new PddGoodsDetailReq();
//        pddGoodsDetailReq.setGoodsSign("E9z2iy0NUAVHeKNxwfja1vPLzaWAtHOg8Q_JQmnYicMUu");
//        PddGoodsDetailResp pddGoodsDetailResp = pddGoodsDetail(pddGoodsDetailReq);
//        System.out.println(pddGoodsDetailResp);

//        TbGoodsDetailReq tbGoodsDetailReq = new TbGoodsDetailReq();
//        tbGoodsDetailReq.setGoodsId("641646674941");
//        TbGoodsDetailResp tbGoodsDetailResp = tbGoodsDetail(tbGoodsDetailReq);
//        System.out.println(tbGoodsDetailResp);

//        JdGoodsDetailReq jdGoodsDetailReq = new JdGoodsDetailReq();
//        jdGoodsDetailReq.setSkuIds("100035207592");
//        List<JdGoodsDetailResp> jdGoodsDetailResps = jdGoodsDetail(jdGoodsDetailReq);
//        System.out.println(jdGoodsDetailResps);
    }
}
