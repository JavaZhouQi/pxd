package com.pxd.dubbo.three.im.entity.account;

public class KickReq {

    /*** 用户名 */
    private String Identifier;

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    /**
     * 失效帐号登录状态 初始化
     * @param userId
     * @return
     */
    public static KickReq init(String userId){
        KickReq kickReq = new KickReq();
        kickReq.setIdentifier(userId);
        return kickReq;
    }
}
