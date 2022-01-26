package com.pxd.module.im.entity.account;

public class ErrorList {

    /*** 状态查询失败的目标帐号 */
    private String To_Account;

    /*** 状态查询失败的错误码，若目标帐号的错误码为70107，表示该帐号不存在 */
    private String ErrorCode;

    public String getTo_Account() {
        return To_Account;
    }

    public void setTo_Account(String to_Account) {
        To_Account = to_Account;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }
}
