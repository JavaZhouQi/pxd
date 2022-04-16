package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class JdToLinkResp {

    /*** 商品转链后的短链接 */
   private String shortUrl;
    /*** 商品转链后的长链接 */
    private String longUrl;

}
