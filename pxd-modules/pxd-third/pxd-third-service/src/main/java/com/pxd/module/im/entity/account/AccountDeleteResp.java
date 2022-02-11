package com.pxd.module.im.entity.account;

import com.pxd.module.im.entity.ImResp;

import java.util.List;

public class AccountDeleteResp extends ImResp {

    /*** 单个帐号的结果对象数组 */
    private List<ResultItem> ResultItem;

    public List<ResultItem> getResultItem() {
        return ResultItem;
    }

    public void setResultItem(List<ResultItem> resultItem) {
        ResultItem = resultItem;
    }
}
