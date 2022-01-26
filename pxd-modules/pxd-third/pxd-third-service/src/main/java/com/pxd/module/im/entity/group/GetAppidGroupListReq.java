package com.pxd.module.im.entity.group;

import com.pxd.dubbo.three.im.enums.GroupTypeEnum;

public class GetAppidGroupListReq {

    /*** 本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000 */
    private Integer Limit;

    /*** 群太多时分页拉取标志，第一次填0，以后填上一次返回的值，返回的 Next 为0代表拉完了 */
    private Integer Next;

    /*** 如果仅需要返回特定群组形态的群组，可以通过 GroupType 进行过滤，但此时返回的 TotalCount 的含义就变成了 App 中属于该群组形态的群组总数。不填为获取所有类型的群组。
     群组形态包括 Public（公开群），Private（即 Work，好友工作群），ChatRoom（即 Meeting，会议群），AVChatRoom（音视频聊天室）和BChatRoom（在线成员广播大群）*/
    private String GroupType;

    public Integer getLimit() {
        return Limit;
    }

    public void setLimit(Integer limit) {
        Limit = limit;
    }

    public Integer getNext() {
        return Next;
    }

    public void setNext(Integer next) {
        Next = next;
    }

    public String getGroupType() {
        return GroupType;
    }

    public void setGroupType(String groupType) {
        GroupType = groupType;
    }

    /**
     *
     */
    public static GetAppidGroupListReq init(GroupTypeEnum groupTypeEnum) {
        GetAppidGroupListReq getAppidGroupListReq = new GetAppidGroupListReq();
        getAppidGroupListReq.setGroupType(groupTypeEnum.toString());
        return getAppidGroupListReq;
    }

}
