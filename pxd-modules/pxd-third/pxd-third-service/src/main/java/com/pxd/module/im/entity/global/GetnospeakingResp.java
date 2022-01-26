package com.pxd.module.im.entity.global;


import com.pxd.dubbo.three.im.entity.ImResp;

public class GetnospeakingResp extends ImResp {

    /**
     * 单聊消息禁言时长，单位为秒，非负整数。等于 0 代表没有被设置禁言；等于最大值4294967295（十六进制 0xFFFFFFFF）代表被设置永久禁言；其它代表该帐号禁言时长，如果等于3600表示该帐号被禁言一小时
     */
    private Long C2CmsgNospeakingTime;

    /**
     * 群组消息禁言时长，单位为秒，非负整数。等于0代表没有被设置禁言；等于最大值4294967295（十六进制 0xFFFFFFFF）代表被设置永久禁言；其它代表该帐号禁言时长，如果等于3600表示该帐号被禁言一小时
     */
    private Long GroupmsgNospeakingTime;

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
