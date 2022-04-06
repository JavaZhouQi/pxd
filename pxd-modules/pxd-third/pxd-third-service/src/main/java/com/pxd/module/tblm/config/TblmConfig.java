package com.pxd.module.tblm.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "tblm")
public class TblmConfig {

    /*** url */
    private String url = "https://eco.taobao.com/router/rest";
    /*** appKey */
    private String appKey = "33605498";
    /*** appSecret */
    private String appSecret = "3363b7401c5bbbd696900815b7d0838b";
    /*** pid */
    private String pid = "mm_2469990045_2608900239_111963800235";

}
