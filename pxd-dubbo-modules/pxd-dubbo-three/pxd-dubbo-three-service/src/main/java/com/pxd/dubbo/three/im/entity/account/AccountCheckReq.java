package com.pxd.dubbo.three.im.entity.account;

import java.util.ArrayList;
import java.util.List;

public class AccountCheckReq {

    /*** 请求检查的帐号对象数组，单次请求最多支持100个帐号 */
    private List<ImItem> CheckItem;

    public List<ImItem> getCheckItem() {
        return CheckItem;
    }

    public void setCheckItem(List<ImItem> checkItem) {
        CheckItem = checkItem;
    }

    /**
     * 初始化im删除账号对象
     *
     * @param userId
     * @return
     */
    public static AccountCheckReq init(String... userId) {
        AccountCheckReq accountCheckReq = new AccountCheckReq();
        List<ImItem> list = new ArrayList<>();
        for (int i = 0; i < userId.length; i++) {
            list.add(new ImItem(userId[i]));
        }
        accountCheckReq.setCheckItem(list);
        return accountCheckReq;
    }
}
