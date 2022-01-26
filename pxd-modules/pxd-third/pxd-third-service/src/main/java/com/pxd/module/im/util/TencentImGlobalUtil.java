package com.pxd.module.im.util;

import com.pxd.dubbo.three.im.entity.ImResp;
import com.pxd.dubbo.three.im.entity.global.GetnospeakingReq;
import com.pxd.dubbo.three.im.entity.global.GetnospeakingResp;
import com.pxd.dubbo.three.im.entity.global.SetnospeakingReq;
import com.pxd.dubbo.three.im.enums.ImUriEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局禁言管理
 */
@Slf4j
public class TencentImGlobalUtil {

    /**
     * 设置全局禁言
     */
    public static boolean setnospeaking(SetnospeakingReq setnospeakingReq) {
        ImResp send = TencentImUtil.send(ImUriEnum.SETNOSPEAKING, setnospeakingReq, ImResp.class);
        return ImResp.isOk(send);
    }

    /**
     * 查询全局禁言
     */
    public static GetnospeakingResp getnospeaking(GetnospeakingReq getnospeakingReq) {
        GetnospeakingResp send = TencentImUtil.send(ImUriEnum.GETNOSPEAKING, getnospeakingReq, GetnospeakingResp.class);
        if (ImResp.isOk(send)) {
            return send;
        }
        throw new RuntimeException();
    }

}
