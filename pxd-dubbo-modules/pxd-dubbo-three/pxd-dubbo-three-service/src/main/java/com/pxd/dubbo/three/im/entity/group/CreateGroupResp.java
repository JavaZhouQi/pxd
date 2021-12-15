package com.pxd.dubbo.three.im.entity.group;


import com.pxd.dubbo.three.im.entity.ImResp;

public class CreateGroupResp extends ImResp {

    /*** 创建成功之后的群 ID，由即时通信 IM 后台分配 */
    private String GroupId;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }
}
