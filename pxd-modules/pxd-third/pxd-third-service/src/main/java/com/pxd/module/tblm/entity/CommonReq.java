package com.pxd.module.tblm.entity;

import lombok.Data;

@Data
public class CommonReq {

    /*** String 是 具体API接口名称，例：taobao.item.seller.get */
    private String method;
    /*** String 是TOP分配给应用的AppKey。例：12345678 */
    private String app_key;
    /***  String 可选 用户授权成功后，平台颁发给应用的授权session，详细介绍请点击这里。当此API文档的标签上注明：“需要授权”，则此参数必传；“不需要授权”，则此参数不需要传。 */
    private String session;
    /***  String 是 时间戳，格式为yyyy-MM-dd HH:mm:ss，时区为GMT+8，例如：2016-01-01 12:00:00。淘宝API服务端允许客户端请求最大时间误差为10分钟。 */
    private String timestamp;
    /***  String 是 API协议版本，可选值：2.0 */
    private String v = "2.0";
    /***  String 是 签名的摘要算法，可选值为：hmac，md5，hmac-sha256。 */
    private String sign_method = "md5";
    /***  String 是 API输入参数签名结果，签名算法参照下面的介绍。 */
    private String sign;
    /***  String 否 返回内容响应格式。不传默认为xml格式，可选值：xml，json。 */
    private String format = "json";
    /*** Boolean 否 是否采用精简JSON返回格式，仅当format=json时有效，可选值：false，true，不传为false。 */
    private boolean simplify = true;

}
