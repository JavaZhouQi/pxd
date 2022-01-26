package com.pxd.module.im.entity.account;

public class ImItem {

    /*** 请求删除的帐号的 UserID */
    private String UserID;

    public ImItem() {
    }

    public ImItem(String userID) {
        UserID = userID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
