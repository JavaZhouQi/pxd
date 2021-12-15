package com.pxd.dubbo.three.im.entity.group;


import java.util.Set;

public class GetGroupInfoReq {

    /*** 需要拉取的群组列表 */
    private Set<String> GroupIdList;
    /*** 包含三个过滤器：GroupBaseInfoFilter，MemberInfoFilter，AppDefinedDataFilter_Group，分别是基础信息字段过滤器，成员信息字段过滤器，群组维度的自定义字段过滤器 */
    // 非必填 >>> 暂时不用
    private ResponseFilter ResponseFilter;

    public Set<String> getGroupIdList() {
        return GroupIdList;
    }

    public void setGroupIdList(Set<String> groupIdList) {
        GroupIdList = groupIdList;
    }

    public ResponseFilter getResponseFilter() {
        return ResponseFilter;
    }

    public void setResponseFilter(ResponseFilter responseFilter) {
        ResponseFilter = responseFilter;
    }

    public static GetGroupInfoReq init(Set<String> groupId){
        GetGroupInfoReq getGroupInfoReq = new GetGroupInfoReq();
        getGroupInfoReq.setGroupIdList(groupId);
        return getGroupInfoReq;
    }
}
