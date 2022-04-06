package com.pxd.module.tblm.entity;

import lombok.Data;

@Data
public class PidCheckReq extends CommonReq {

    /*** mm_1_1_1	需要校验的三段式pid */
    private String pid;


}
