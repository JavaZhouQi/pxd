package com.pxd.dubbo.three.wechat.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class WechatErrorEntity {
    private final static Integer SUCCESS_CODE = 0;
    /**
     * 错误编码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    /**
     * 处理结果 成功 or 失败
     */
    public boolean isSuccess() {
        return errcode == null || Objects.equals(errcode, SUCCESS_CODE);
    }
}
