package com.pxd.module.im.entity.account;

import java.util.Objects;

public class AccountCheckResultItem extends ResultItem {

    private final static String imported = "Imported";

    /*** 单个帐号的导入状态：Imported 表示已导入，NotImported 表示未导入 */
    private String AccountStatus;

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    /***
     * 导入状态
     * @param accountCheckResultItem
     * @return
     */
    public static boolean isAccountStatus(AccountCheckResultItem accountCheckResultItem) {
        return Objects.equals(accountCheckResultItem.getAccountStatus(), imported);
    }

}
