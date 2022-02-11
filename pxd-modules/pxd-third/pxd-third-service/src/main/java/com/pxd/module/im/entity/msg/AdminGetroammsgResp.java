package com.pxd.module.im.entity.msg;


import com.pxd.module.im.entity.ImResp;

import java.util.List;

public class AdminGetroammsgResp extends ImResp {
    /*** 是否全部拉取，0表示未全部拉取，需要续拉，1表示已全部拉取 */
    private Integer Complete;
    /*** 本次拉取到的消息条数 */
    private Integer MsgCnt;
    /*** 本次拉取到的消息里的最后一条消息的时间 */
    private Long LastMsgTime;
    /*** 本次拉取到的消息里的最后一条消息的标识 */
    private String LastMsgKey;
    /*** 返回的消息列表 */
    //TODO 消息对象后期需要在增加
    private List<String> MsgList;

    public Integer getComplete() {
        return Complete;
    }

    public void setComplete(Integer complete) {
        Complete = complete;
    }

    public Integer getMsgCnt() {
        return MsgCnt;
    }

    public void setMsgCnt(Integer msgCnt) {
        MsgCnt = msgCnt;
    }

    public Long getLastMsgTime() {
        return LastMsgTime;
    }

    public void setLastMsgTime(Long lastMsgTime) {
        LastMsgTime = lastMsgTime;
    }

    public String getLastMsgKey() {
        return LastMsgKey;
    }

    public void setLastMsgKey(String lastMsgKey) {
        LastMsgKey = lastMsgKey;
    }

    public List<String> getMsgList() {
        return MsgList;
    }

    public void setMsgList(List<String> msgList) {
        MsgList = msgList;
    }
}
