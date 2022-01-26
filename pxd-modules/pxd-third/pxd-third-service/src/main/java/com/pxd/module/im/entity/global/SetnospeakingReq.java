package com.pxd.module.im.entity.global;

public class SetnospeakingReq {

    /*** 设置禁言配置的帐号 */
    private String Set_Account;

    /***
     单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）
     0表示取消该帐号的单聊消息禁言
     4294967295表示该帐号被设置永久禁言
     其它值表示该帐号具体的禁言时间
     */
    private Long C2CmsgNospeakingTime;

    /***
     群组消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）
     0表示取消该帐号的群组消息禁言
     4294967295表示该帐号被设置永久禁言
     其它值表示该帐号的具体禁言时间
     */
    private Long GroupmsgNospeakingTime;

    public String getSet_Account() {
        return Set_Account;
    }

    public void setSet_Account(String set_Account) {
        Set_Account = set_Account;
    }

    public Long getC2CmsgNospeakingTime() {
        return C2CmsgNospeakingTime;
    }

    public void setC2CmsgNospeakingTime(Long c2CmsgNospeakingTime) {
        C2CmsgNospeakingTime = c2CmsgNospeakingTime;
    }

    public Long getGroupmsgNospeakingTime() {
        return GroupmsgNospeakingTime;
    }

    public void setGroupmsgNospeakingTime(Long groupmsgNospeakingTime) {
        GroupmsgNospeakingTime = groupmsgNospeakingTime;
    }
}
