package com.pxd.dubbo.three.im.entity.msg;

import java.util.List;

public class SendMsgReq {

    /*** 1：把消息同步到 From_Account 在线终端和漫游上；2：消息不同步至 From_Account； 若不填写默认情况下会将消息存 From_Account 漫游*/
    private Integer SyncOtherMachine;
    /*** 消息发送方 UserID（用于指定发送消息方帐号） */
    private String From_Account;
    /*** 消息接收方 UserID */
    private String To_Account;
    /*** 消息离线保存时长（单位：秒），最长为7天（604800秒）若设置该字段为0，则消息只发在线用户，不保存离线若设置该字段超过7天（604800秒），仍只保存7天 若不设置该字段，则默认保存7天*/
    private Integer MsgLifeTime;
    /*** 消息序列号，后台会根据该字段去重及进行同秒内消息的排序，详细规则请看本接口的功能说明。若不填该字段，则由后台填入随机数。*/
    private Integer MsgSeq;
    /*** 消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数 */
    private Integer MsgRandom;
    /*** 消息时间戳，UNIX 时间戳（单位：秒）*/
    private Integer MsgTimeStamp;
    /*** 消息回调禁止开关，只对本条消息有效，ForbidBeforeSendMsgCallback 表示禁止发消息前回调，ForbidAfterSendMsgCallback 表示禁止发消息后回调 */
    private List<String> ForbidCallbackControl;
    /*** 消息发送控制选项，是一个 String 数组，只对本条消息有效。"NoUnread"表示该条消息不计入未读数。"NoLastMsg"表示该条消息不更新会话列表。"WithMuteNotifications"表示该条消息的接收方对发送方设置的免打扰选项生效（默认不生效）。示例："SendMsgControl": ["NoUnread","NoLastMsg","WithMuteNotifications"]*/
    private List<String> SendMsgControl;
    /*** 消息内容，具体格式请参考 消息格式描述（注意，一条消息可包括多种消息元素，MsgBody 为 Array 类型）*/
    private List<MsgBody> MsgBody;
    /*** 消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）*/
    private String CloudCustomData;
    /*** 离线推送信息配置，具体可参考 消息格式描述 */
    private Object OfflinePushInfo;

    public Integer getSyncOtherMachine() {
        return SyncOtherMachine;
    }

    public void setSyncOtherMachine(Integer syncOtherMachine) {
        SyncOtherMachine = syncOtherMachine;
    }

    public String getFrom_Account() {
        return From_Account;
    }

    public void setFrom_Account(String from_Account) {
        From_Account = from_Account;
    }

    public String getTo_Account() {
        return To_Account;
    }

    public void setTo_Account(String to_Account) {
        To_Account = to_Account;
    }

    public Integer getMsgLifeTime() {
        return MsgLifeTime;
    }

    public void setMsgLifeTime(Integer msgLifeTime) {
        MsgLifeTime = msgLifeTime;
    }

    public Integer getMsgSeq() {
        return MsgSeq;
    }

    public void setMsgSeq(Integer msgSeq) {
        MsgSeq = msgSeq;
    }

    public Integer getMsgRandom() {
        return MsgRandom;
    }

    public void setMsgRandom(Integer msgRandom) {
        MsgRandom = msgRandom;
    }

    public Integer getMsgTimeStamp() {
        return MsgTimeStamp;
    }

    public void setMsgTimeStamp(Integer msgTimeStamp) {
        MsgTimeStamp = msgTimeStamp;
    }

    public List<String> getForbidCallbackControl() {
        return ForbidCallbackControl;
    }

    public void setForbidCallbackControl(List<String> forbidCallbackControl) {
        ForbidCallbackControl = forbidCallbackControl;
    }

    public List<String> getSendMsgControl() {
        return SendMsgControl;
    }

    public void setSendMsgControl(List<String> sendMsgControl) {
        SendMsgControl = sendMsgControl;
    }

    public List<MsgBody> getMsgBody() {
        return MsgBody;
    }

    public void setMsgBody(List<MsgBody> msgBody) {
        MsgBody = msgBody;
    }

    public String getCloudCustomData() {
        return CloudCustomData;
    }

    public void setCloudCustomData(String cloudCustomData) {
        CloudCustomData = cloudCustomData;
    }

    public Object getOfflinePushInfo() {
        return OfflinePushInfo;
    }

    public void setOfflinePushInfo(Object offlinePushInfo) {
        OfflinePushInfo = offlinePushInfo;
    }
}
