package com.pxd.module.dtk.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class DtkBaseResp {

    private final static int SUCCESS_CODE = 0;

    private Integer code;

    private String msg;

    private String data;

    private Long time;

    private String requestId;

    public static boolean isSuccess(DtkBaseResp dtkBaseResp) {
        return Objects.equals(SUCCESS_CODE, dtkBaseResp.getCode());
    }

}
