package com.pxd.dubbo.three.im.entity.account;

import java.util.HashSet;
import java.util.Set;

public class MultiaccountImportReq {

    /*** 用户名，单个用户名长度不超过32字节，单次最多导入100个用户名 */
    private Set<String> Accounts;

    public Set<String> getAccounts() {
        return Accounts;
    }

    public void setAccounts(Set<String> accounts) {
        Accounts = accounts;
    }

    /**
     * 导入多个帐号 初始化
     * @param userId 用户Id
     * @return 导入多个帐号对象
     */
    public static MultiaccountImportReq init(String... userId) {
        MultiaccountImportReq multiaccountImportReq = new MultiaccountImportReq();
        Set<String> hashSet = new HashSet<>(userId.length);
        for (int i = 0; i < userId.length; i++) {
            hashSet.add(userId[i]);
        }
        multiaccountImportReq.setAccounts(hashSet);
        return multiaccountImportReq;
    }
}
