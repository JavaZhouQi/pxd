package com.pxd.module.im.entity.group;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DeleteGroupMemberReq {
    /*** 操作的群 ID */
    private String GroupId;
    /*** 是否静默删人。0表示非静默删人，1表示静默删人。静默即删除成员时不通知群里所有成员，只通知被删除群成员。不填写该字段时默认为0*/
    private Integer Silence;
    /*** 踢出用户原因 */
    private String Reason;
    /*** 待删除的群成员 */
    private Set<String> MemberToDel_Account;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public Integer getSilence() {
        return Silence;
    }

    public void setSilence(Integer silence) {
        Silence = silence;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Set<String> getMemberToDel_Account() {
        return MemberToDel_Account;
    }

    public void setMemberToDel_Account(Set<String> memberToDel_Account) {
        MemberToDel_Account = memberToDel_Account;
    }

    /**
     * 删除群成员初始化
     *
     * @param groupId 操作的群ID
     * @param reason  踢出用户原因（可以未空）
     * @param userId  用户id
     * @return DeleteGroupMemberReq
     */
    public static DeleteGroupMemberReq init(String groupId, String reason, String... userId) {
        DeleteGroupMemberReq deleteGroupMemberReq = new DeleteGroupMemberReq();
        deleteGroupMemberReq.setGroupId(groupId);
        deleteGroupMemberReq.setSilence(1);
        deleteGroupMemberReq.setReason(reason);
        Set<String> set = new HashSet<>();
        Collections.addAll(set, userId);
        deleteGroupMemberReq.setMemberToDel_Account(set);
        return deleteGroupMemberReq;
    }
}
