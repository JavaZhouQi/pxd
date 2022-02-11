package com.pxd.module.im.util;

import com.pxd.module.im.entity.ImResp;
import com.pxd.module.im.entity.msg.AdminGetroammsgReq;
import com.pxd.module.im.entity.msg.AdminGetroammsgResp;
import com.pxd.module.im.entity.msg.SendMsgReq;
import com.pxd.module.im.enums.ImUriEnum;

public class TencentImMsgUtil {

    /**
     * 单发单聊消息
     */
    public static boolean sendMsg(SendMsgReq sendMsgReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.SENDMSG, sendMsgReq, ImResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 查询单聊消息
     */
    public static AdminGetroammsgResp adminGetroammsg(AdminGetroammsgReq adminGetroammsgReq) {
        AdminGetroammsgResp send = TencentImUtil.send(ImUriEnum.SENDMSG, adminGetroammsgReq, AdminGetroammsgResp.class);
        if (ImResp.isOk(send)) {
            return send;
        }
        throw new RuntimeException("腾讯IM查询单聊消息异常");
    }

}
