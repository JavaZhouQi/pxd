package com.pxd.module.im.util;

import com.pxd.dubbo.three.im.entity.ImResp;
import com.pxd.dubbo.three.im.enums.ImUriEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 群组管理
 */
@Slf4j
public class TencentImGroupUtil {

    /**
     * 获取App中的所有群组
     */
    public static GetAppidGroupListResp getAppidGroupList(GetAppidGroupListReq getAppidGroupListReq) {
        GetAppidGroupListResp send = TencentImUtil.send(ImUriEnum.GET_APPID_GROUP_LIST, getAppidGroupListReq, GetAppidGroupListResp.class);
        if (ImResp.isOk(send)) {
            return send;
        }
        throw new RuntimeException("腾讯IM查询App中的所有群组异常");
    }

    /**
     * 获取群详细资料
     */
    public static GetGroupInfoResp getGroupInfo(GetGroupInfoReq getGroupInfoReq) {
        GetGroupInfoResp send = TencentImUtil.send(ImUriEnum.GET_GROUP_INFO, getGroupInfoReq, GetGroupInfoResp.class);
        if (ImResp.isOk(send)) {
            return send;
        }
        throw new RuntimeException("腾讯IM查询App中的所有群组异常");
    }

    /**
     * 创建群组
     */
    public static String createGroup(CreateGroupReq createGroupReq) {
        CreateGroupResp send = TencentImUtil.send(ImUriEnum.CREATE_GROUP, createGroupReq, CreateGroupResp.class);
        if (ImResp.isOk(send)) {
            return send.getGroupId();
        }
        throw new RuntimeException("腾讯IM创建群组异常");
    }

    /**
     * 删除群成员
     */
    public static boolean deleteGroupMember(DeleteGroupMemberReq deleteGroupMemberReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.DELETE_GROUP_MEMBER, deleteGroupMemberReq, ImResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 在群组中发送普通消息
     */
    public static boolean sendGroupMsg(SendGroupMsgReq sendGroupMsgReq) {
        SendGroupMsgResp send = TencentImUtil.send(ImUriEnum.SEND_GROUP_MSG, sendGroupMsgReq, SendGroupMsgResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 在群组中发送系统通知
     */
    public static boolean sendGroupSystemNotification(SendGroupNoticeReq sendGroupNoticeReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.SEND_GROUP_SYSTEM_NOTIFICATION, sendGroupNoticeReq, ImResp.class);
        return ImResp.isOk(send);
    }

}
