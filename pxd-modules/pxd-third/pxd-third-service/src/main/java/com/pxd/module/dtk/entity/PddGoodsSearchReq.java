package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class PddGoodsSearchReq extends DtkBaseReq {

    /*** 活动商品标记数组，例：[4,7]， 4-秒杀，7-百亿补贴，31-品牌黑标，10564-精选爆品-官方直推爆款，10584-精选爆品-团长推荐， 24-品牌高佣，20-行业精选，21-金牌商家，10044-潜力爆品，10475-爆品上新，其他的值请忽略 */
    private String activityTags;
    /*** 自定义屏蔽一级/二级/三级类目ID，自定义数量不超过20个; */
    private String blockCats;
    /*** 屏蔽商品类目包：1-拼多多小程序屏蔽的类目&关键词;2-虚拟类目;3-医疗器械;4-处方药;5-非处方药 */
    private String blockCatPackages;
    /***  商品类目ID */
    private Integer catId;
    /***  复制 商品goodsSign列表 访问括号内链接可查看字段相关说明(http://www.dataoke.com/kfpt/open-gz.html?id=100) */
    private String goodsSignList;
    /***  是否为品牌商品 */
    private Integer isBrandGoods;
    /*** 商品关键词(暂不支持goodid进行搜索，如需定向搜索商品建议使用goodsign进行搜索) */
    private String keyword;
    /*** 翻页时建议填写前页返回的list_id值 */
    private String listId;
    /*** 店铺类型数组 1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部） */
    private String merchantTypeList;
    /*** 商品标签类目ID */
    private Integer optId;
    /*** 默认值1，商品分页数 */
    private Long page = 1L;
    /*** 默认100，每页商品数量 */
    private Long pageSize = 10L;
    /*** 筛选范围列表 样例：[{"range_id":0,"range_from":1,"range_to":1500}, {"range_id":1,"range_from":1,"range_to":1500}] */
    private String rangeList;
    /*** 排序方式:0-综合排序;2-按佣金比例降序;3-按价格升序;4-按价格降序;6-按销量降序;9-券后价升序排序;10-券后价降序排序;16-店铺描述评分降序 */
    private Integer sortType;
    /*** 是否只返回优惠券的商品，0返回所有商品，1只返回有优惠券的商品 */
    private Integer withCoupon;
    /*** 拼多多推广位id（建议填写，可获取对应账号等级的佣金比例） */
    private String pid;
    /*** 自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，其中 uid 为用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 为上下文信息标识，例如sessionId等，非必填。该json字符串中也可以加入其他自定义的key（建议填写，可用于获取对应账号等级下的佣金比例。若填写了customParameters就必须填写PID） */
    private String customParameters;
    /*** 是否返回分类信息数据 0-否；1-是 */
    private Integer withCategoryInfo;

}
