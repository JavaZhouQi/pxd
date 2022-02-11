package com.pxd.module.im.entity.group;

import com.pxd.module.im.entity.msg.MsgBody;

import java.util.List;

public class SendGroupMsgReq {

    /*** 向哪个群组发送消息 */
    private String GroupId;
    /*** 无符号32位整数。如果5分钟内两条消息的随机值相同，后一条消息将被当做重复消息而丢弃 */
    private Integer Random;
    /*** 消息的优先级 */
    private String MsgPriority;
    /*** 消息体 */
    private List<MsgBody> MsgBody;
    /*** 消息来源帐号，选填。如果不填写该字段，则默认消息的发送者为调用该接口时使用的 App 管理员帐号。除此之外，App 亦可通过该字段“伪造”消息的发送者，从而实现一些特殊的功能需求。需要注意的是，如果指定该字段，必须要确保字段中的帐号是存在的 */
    private String From_Account;
    /*** 离线推送信息配置，详细可参阅 消息格式描述 */
    private Object OfflinePushInfo;
    /*** 消息回调禁止开关，只对单条消息有效，ForbidBeforeSendMsgCallback 表示禁止发消息前回调，ForbidAfterSendMsgCallback 表示禁止发消息后回调*/
    private List<String> ForbidCallbackControl;
    /*** 1表示消息仅发送在线成员，默认0表示发送所有成员，AVChatRoom(直播群)不支持该参数 */
    private Integer OnlineOnlyFlag;
    /*** 消息发送权限，NoLastMsg 只对单条消息有效，表示不更新最近联系人会话；NoUnread 不计未读，只对单条消息有效。（如果该消息 OnlineOnlyFlag 设置为1，则不允许使用该字段。） */
    private List<String> SendMsgControl;
    /*** 消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）*/
    private String CloudCustomData;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public Integer getRandom() {
        return Random;
    }

    public void setRandom(Integer random) {
        Random = random;
    }

    public String getMsgPriority() {
        return MsgPriority;
    }

    public void setMsgPriority(String msgPriority) {
        MsgPriority = msgPriority;
    }

    public List<MsgBody> getMsgBody() {
        return MsgBody;
    }

    public void setMsgBody(List<MsgBody> msgBody) {
        MsgBody = msgBody;
    }

    public String getFrom_Account() {
        return From_Account;
    }

    public void setFrom_Account(String from_Account) {
        From_Account = from_Account;
    }

    public Object getOfflinePushInfo() {
        return OfflinePushInfo;
    }

    public void setOfflinePushInfo(Object offlinePushInfo) {
        OfflinePushInfo = offlinePushInfo;
    }

    public List<String> getForbidCallbackControl() {
        return ForbidCallbackControl;
    }

    public void setForbidCallbackControl(List<String> forbidCallbackControl) {
        ForbidCallbackControl = forbidCallbackControl;
    }

    public Integer getOnlineOnlyFlag() {
        return OnlineOnlyFlag;
    }

    public void setOnlineOnlyFlag(Integer onlineOnlyFlag) {
        OnlineOnlyFlag = onlineOnlyFlag;
    }

    public List<String> getSendMsgControl() {
        return SendMsgControl;
    }

    public void setSendMsgControl(List<String> sendMsgControl) {
        SendMsgControl = sendMsgControl;
    }

    public String getCloudCustomData() {
        return CloudCustomData;
    }

    public void setCloudCustomData(String cloudCustomData) {
        CloudCustomData = cloudCustomData;
    }
}
