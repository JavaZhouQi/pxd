package com.pxd.dubbo.three.im.entity.group;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SendGroupNoticeReq {

    /*** 向哪个群组发送系统通知 */
    private String GroupId;

    /*** 接收者群成员列表，请填写接收者 UserID，不填或为空表示全员下发 */
    private Set<String> ToMembers_Account;

    /*** 系统通知的内容 */
    private String Content;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public Set<String> getToMembers_Account() {
        return ToMembers_Account;
    }

    public void setToMembers_Account(Set<String> toMembers_Account) {
        ToMembers_Account = toMembers_Account;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    /**
     *
     * @param groupId 群ID
     * @param content 系统通知的内容
     * @param userId 接收者群成员列表，请填写接收者 UserID
     * @return
     */
    public static SendGroupNoticeReq init(String groupId, String content, String... userId) {
        SendGroupNoticeReq sendGroupNoticeReq = new SendGroupNoticeReq();
        sendGroupNoticeReq.setGroupId(groupId);
        sendGroupNoticeReq.setContent(content);
        Set<String> list = new HashSet<>();
        Collections.addAll(list, userId);
        sendGroupNoticeReq.setToMembers_Account(list);
        return sendGroupNoticeReq;
    }
}
