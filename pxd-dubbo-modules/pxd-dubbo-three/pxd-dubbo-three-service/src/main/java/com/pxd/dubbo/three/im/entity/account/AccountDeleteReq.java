package com.pxd.dubbo.three.im.entity.account;

import java.util.ArrayList;
import java.util.List;

public class AccountDeleteReq {

    /*** 请求删除的帐号对象数组，单次请求最多支持100个帐号 */
    private List<ImItem> DeleteItem;

    public List<ImItem> getDeleteItem() {
        return DeleteItem;
    }

    public void setDeleteItem(List<ImItem> imItem) {
        DeleteItem = imItem;
    }

    /**
     * 初始化im删除账号对象
     *
     * @param userId
     * @return
     */
    public static AccountDeleteReq init(String... userId) {
        AccountDeleteReq accountDeleteReq = new AccountDeleteReq();
        List<ImItem> list = new ArrayList<>();
        for (int i = 0; i < userId.length; i++) {
            list.add(new ImItem(userId[i]));
        }
        accountDeleteReq.setDeleteItem(list);
        return accountDeleteReq;
    }
}
