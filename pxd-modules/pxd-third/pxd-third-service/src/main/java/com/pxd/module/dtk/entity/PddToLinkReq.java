package com.pxd.module.dtk.entity;

import lombok.Data;

@Data
public class PddToLinkReq extends DtkBaseReq {

    /*** 拼多多推广位id */
    private String pid;
    /*** 商品goodsSign 访问括号内链接可查看字段相关说明(http://www.dataoke.com/kfpt/open-gz.html?id=100) */
    private String goodsSign;
    /*** 自定义参数，为链接打上自定义标签； 自定义参数最长限制64个字节； 格式为： {"uid":"11111","sid":"22222"} ， 其中 uid 用户唯一标识，可自行加密后传入， 每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等， 非必填。该json字符串中也可以加入其他自定义的key In */
    private String customParameters;
    /*** 招商多多客ID */
    private String zsDuoId;

}
