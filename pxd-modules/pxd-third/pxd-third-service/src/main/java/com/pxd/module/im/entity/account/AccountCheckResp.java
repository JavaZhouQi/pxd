package com.pxd.module.im.entity.account;

import com.pxd.module.im.entity.ImResp;

import java.util.List;

public class AccountCheckResp extends ImResp {

    /*** 单个帐号的结果对象数组 */
    private List<AccountCheckResultItem> ResultItem;

    public List<AccountCheckResultItem> getResultItem() {
        return ResultItem;
    }

    public void setResultItem(List<AccountCheckResultItem> resultItem) {
        ResultItem = resultItem;
    }
}
