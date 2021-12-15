package com.pxd.dubbo.three.im.entity.account;

import com.pxd.dubbo.three.im.entity.ImResp;

import java.util.Set;

public class MultiaccountImportResp extends ImResp {
    /*** 导入失败的帐号列表 */
    private Set<String> FailAccounts;

    public Set<String> getFailAccounts() {
        return FailAccounts;
    }

    public void setFailAccounts(Set<String> failAccounts) {
        FailAccounts = failAccounts;
    }
}
