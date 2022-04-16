package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class DtkBaseReq {

    /*** 应用的唯一验证 */
    private String appKey;

    /*** API接口版本号 */
    private String version;

}
