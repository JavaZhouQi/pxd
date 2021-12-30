package com.pxd.dubbo.three.im.entity.account;

import java.util.ArrayList;
import java.util.List;

public class AueryOnlineStatusReq {

    /*** 需要查询这些 UserID 的登录状态，一次最多查询500个 UserID 的状态 */
    private List<String> To_Account;

    /*** 是否需要返回详细的登录平台信息。0表示不需要，1表示需要 */
    private Integer IsNeedDetail;

    public List<String> getTo_Account() {
        return To_Account;
    }

    public void setTo_Account(List<String> to_Account) {
        To_Account = to_Account;
    }

    public Integer getIsNeedDetail() {
        return IsNeedDetail;
    }

    public void setIsNeedDetail(Integer isNeedDetail) {
        IsNeedDetail = isNeedDetail;
    }

    /**
     * 查询帐号在线状态对象 初始化
     *
     * @param userId 用户Id
     * @return 查询帐号在线状态对象
     */
    public static AueryOnlineStatusReq init(String... userId) {
        AueryOnlineStatusReq aueryOnlineStatusReq = new AueryOnlineStatusReq();
        List<String> list = new ArrayList<>(userId.length);
        for (int i = 0; i < userId.length; i++) {
            list.add(userId[i]);
        }
        aueryOnlineStatusReq.setTo_Account(list);
        return aueryOnlineStatusReq;
    }

    /**
     * 查询帐号在线状态对象 初始化
     *
     * @param isNeedDetail 是否需要返回详细的登录平台信息。0表示不需要，1表示需要
     * @param userId       用户id
     * @return 查询帐号在线状态对象
     */
    public static AueryOnlineStatusReq init(int isNeedDetail, String... userId) {
        AueryOnlineStatusReq aueryOnlineStatusReq = init(userId);
        aueryOnlineStatusReq.setIsNeedDetail(isNeedDetail);
        return aueryOnlineStatusReq;
    }
}
