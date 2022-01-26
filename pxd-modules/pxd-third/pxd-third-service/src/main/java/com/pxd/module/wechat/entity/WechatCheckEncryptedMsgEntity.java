package com.pxd.module.wechat.entity;

import lombok.Data;

@Data
public class WechatCheckEncryptedMsgEntity extends WechatErrorEntity {

    /**
     * 是否是合法的数据
     */
    private Boolean vaild;

    /**
     * 加密数据生成的时间戳
     */
    private Long create_time;

}
