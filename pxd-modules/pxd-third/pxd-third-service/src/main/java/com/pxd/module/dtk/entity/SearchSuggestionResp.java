package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class SearchSuggestionResp {

    /*** 联想词 */
    private String kw;
    /*** 对应联想词的商品数量（仅大淘客搜索返回该参数，当使用接口参数为2和3时，不会返回该字段） */
    private String total;

}
