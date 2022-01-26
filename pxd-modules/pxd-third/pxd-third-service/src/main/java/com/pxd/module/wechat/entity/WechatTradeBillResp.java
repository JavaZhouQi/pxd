package com.pxd.module.wechat.entity;

import lombok.Data;

@Data
public class WechatTradeBillResp {

    /**
     * 哈希类型
     * 原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。
     */
    private String hash_type;
    /**
     * 哈希值
     * 原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。
     */
    private String hash_value;
    /**
     * 账单下载地址
     * 供下一步请求账单文件的下载地址，该地址30s内有效。
     */
    private String download_url;

}
