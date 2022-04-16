package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.List;

@Data
public class CommentListResp {
    /*** 评论总数 */
    private String ommentCount;
    /*** 追加评论总数 */
    private String commentAppendCount;
    /*** 商品评论列表 */
    private List<Comment> commentList;
    /*** 评论的标签列表 */
    private List<Tag> tagList;

    @Data
    public static class Comment {
        /*** 评论图片 */
        private String images;
        /*** 评论内容 */
        private String commentContent;
        /*** 评论日期 */
        private String commentDate;
        /*** 买家名称 */
        private String userNick;
        /*** 买家头像 */
        private String headPicUrl;
        /*** 视频首帧图 */
        private String coverUrl;
        /*** 视频链接 */
        private String videoUrl;
        /*** 购买分类 */
        private String skuMap;
        /*** 追评间隔日*/
        private String intervalDay;
    }

    @Data
    public static class Tag {
        /*** 标签数量 */
        private String count;
        /*** 标签 */
        private String tag;
    }
}
