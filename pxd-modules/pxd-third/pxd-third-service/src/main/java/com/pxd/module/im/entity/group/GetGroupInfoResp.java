package com.pxd.module.im.entity.group;

import com.pxd.dubbo.three.im.entity.ImResp;

import java.util.List;

public class GetGroupInfoResp extends ImResp {

    /*** 返回结果为群组信息数组，内容包括群基础资料字段、群成员资料字段、群组维度自定义字段和群成员维度自定义字段，字段详情请参阅 群组数据结构介绍*/
    private List<GroupInfo> GroupInfo;

    public List<GroupInfo> getGroupInfo() {
        return GroupInfo;
    }

    public void setGroupInfo(List<GroupInfo> groupInfo) {
        GroupInfo = groupInfo;
    }
}
