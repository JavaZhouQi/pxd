package com.pxd.dubbo.three.im.entity.group;

import com.pxd.dubbo.three.im.entity.ImResp;

public class SendGroupMsgResp extends ImResp {
    /*** 消息发送的时间戳，对应后台 server 时间*/
    private Long MsgTime;

    /*** 消息序列号，唯一标示一条消息 */
    private Integer MsgSeq;

    public Long getMsgTime() {
        return MsgTime;
    }

    public void setMsgTime(Long msgTime) {
        MsgTime = msgTime;
    }

    public Integer getMsgSeq() {
        return MsgSeq;
    }

    public void setMsgSeq(Integer msgSeq) {
        MsgSeq = msgSeq;
    }
}
