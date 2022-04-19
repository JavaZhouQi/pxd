package com.pxd.dto.goods;

import com.pxd.enums.PlatformEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class SearchReq {

    @ApiModelProperty(value = "搜索文本", required = true)
    @NotBlank(message = "搜索文本不能为空")
    private String text;

    /***
     * {@link PlatformEnum}
     */
    @NotBlank(message = "平台不能为空")
    @ApiModelProperty(value = "平台 tb:淘宝，jd:京东，pdd:拼多多 默认：tb")
    private String platform = PlatformEnum.TB.getPlatform();

    @Min(value = 1, message = "当前页最小值为1")
    @ApiModelProperty(value = "当前页 默认为:1")
    private String page = "1";

    @Max(value = 30, message = "分页最大值为30")
    @Min(value = 10, message = "分页最小值为10")
    @ApiModelProperty(value = "每页数量 默认为：20 最大值为：30，最小值为：10")
    private String pageSize = "20";

    @Max(value = 1, message = "是否有券最大值为1")
    @Min(value = 0, message = "是否有券最小值为0")
    @ApiModelProperty(value = "是否有券 0:无券 1:有券 , 默认有券")
    private Integer hasCoupon = 1;

    @ApiModelProperty(value = "淘宝搜索条件")
    private TbCondition tbCondition = new TbCondition();

    @ApiModelProperty(value = "拼多多搜索条件")
    private PddCondition pddCondition = new PddCondition();

    @ApiModelProperty(value = "京东搜索条件")
    private JdCondition jdCondition = new JdCondition();

    @Data
    public static class TbCondition {
        @ApiModelProperty(value = "是否天猫商品：1-天猫商品，0-所有商品，不填默认为0")
        private String tmall;
        @ApiModelProperty(value = "排序字段信息 销量（total_sales） 价格（price），排序_des（降序），排序_asc（升序），示例：升序查询销量total_sales_asc 新增排序字段和排序方式，默认为0，0-综合排序，1-销量从高到低，2-销量从低到高，5-价格从高到低，6-价格从低到高(2021/1/15新增字段，之前的排序方式也可以使用) ")
        private String sort;
    }

    @Data
    public static class PddCondition {
        @ApiModelProperty(value = "是否为品牌商品")
        private Integer isBrandGoods;
        @ApiModelProperty(value = "排序方式:0-综合排序，3-按价格升序，4-按价格降序，6-按销量降序，9-券后价升序排序，10-券后价降序排序，16-店铺描述评分降序")
        private Integer sortType;
        @ApiModelProperty(value = "店铺类型数组 1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）")
        private String merchantTypeList;
    }

    @Data
    public static class JdCondition {
        @ApiModelProperty(value = "商品券后价格下限")
        private String priceFrom;
        @ApiModelProperty(value = "商品券后价格上限")
        private String priceTo;
        @ApiModelProperty(value = "商品类型：自营[g]，POP[p]")
        private String owner;
        @ApiModelProperty(value = "排序字段(price：单价, inOrderCount30Days：30天引单量")
        private String sortName;
        @ApiModelProperty(value = "asc：升序；desc：降序。默认降序")
        private String sort;
        @ApiModelProperty(value = "拼购价格区间开始")
        private String pingouPriceStart;
        @ApiModelProperty(value = "拼购价格区间结束")
        private String pingouPriceEnd;
    }
}
