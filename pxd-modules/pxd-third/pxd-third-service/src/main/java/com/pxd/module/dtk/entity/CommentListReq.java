package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class CommentListReq extends DtkBaseReq {

    /*** 大淘客商品id（id和goodsid其中一个必填） */
    private String id;
    /*** 淘宝商品id（id和goodsid其中一个必填） */
    private String goodsId;
    /*** 默认：0-全部 评论类型：0-全部；1-含图；2-含视频； */
    private String type;
    /*** 排序方式 0-按热度排序 1-按最新添加排序 默认为0 */
    private String sort;
    /*** 评论类型 0-全部 1-去掉默认好评 默认为0(2020/12/30新增字段) */
    private String haopingType;

}
