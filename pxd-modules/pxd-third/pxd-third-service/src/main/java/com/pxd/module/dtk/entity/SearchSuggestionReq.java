package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class SearchSuggestionReq extends DtkBaseReq {

    /*** 关键词 */
    private String keyWords;
    /*** 当前搜索API类型：1.大淘客搜索 2.联盟搜索 3.超级搜索 */
    private String type = "3";

}
