package com.pxd.module.im.entity.account;

import com.pxd.dubbo.three.im.entity.ImResp;
import com.pxd.dubbo.three.im.entity.account.ResultItem;

import java.util.List;

public class AccountDeleteResp extends ImResp {

    /*** 单个帐号的结果对象数组 */
    private List<com.pxd.dubbo.three.im.entity.account.ResultItem> ResultItem;

    public List<ResultItem> getResultItem() {
        return ResultItem;
    }

    public void setResultItem(List<ResultItem> resultItem) {
        ResultItem = resultItem;
    }
}
